package com.sifu.mynotebook.presentation.view.coin

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sifu.mynotebook.databinding.ActivityMainBinding
import com.sifu.mynotebook.presentation.state.CoinState
import com.sifu.mynotebook.presentation.view.coinDetail.CoinDetailActivity
import com.sifu.mynotebook.presentation.viewmodel.coin.CoinViewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CoinViewmodel by viewModels()
    private lateinit var adapter: CoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        observeState()
    }

    private fun setupRecyclerView() {
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }
    }
    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    updateUI(state)
                }
            }
        }
    }
    private fun updateUI(state: CoinState) {
        binding.apply {
            // Handle loading state
            progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE

            // Handle error state
            if (state.error.isNotBlank()) {
                errorText.visibility = View.VISIBLE
                errorText.text = state.error
                recyclerview.visibility = View.GONE
            } else {
                errorText.visibility = View.GONE
            }

            // Handle success state
            if (state.coins.isNotEmpty()) {
                recyclerview.visibility = View.VISIBLE
                adapter = CoinAdapter(state.coins){
                    navigateToCoinDetail(it)
                }
                recyclerview.adapter = adapter
            } else if (!state.isLoading && state.error.isBlank()) {
                // Empty state
                errorText.visibility = View.VISIBLE
                errorText.text = "No coins available"
                recyclerview.visibility = View.GONE
            }
        }
    }
    private fun navigateToCoinDetail(coinId: String) {
        val intent = CoinDetailActivity.newIntent(this, coinId)
        startActivity(intent)
    }
}