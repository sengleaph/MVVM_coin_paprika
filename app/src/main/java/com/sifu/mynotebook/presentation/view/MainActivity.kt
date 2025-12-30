package com.sifu.mynotebook.presentation.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sifu.mynotebook.R
import com.sifu.mynotebook.databinding.ActivityMainBinding
import com.sifu.mynotebook.presentation.viewmodel.CoinViewmodel
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
    private fun updateUI(state: com.sifu.mynotebook.presentation.state.CoinState) {
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
                adapter = CoinAdapter(state.coins)
                recyclerview.adapter = adapter
            } else if (!state.isLoading && state.error.isBlank()) {
                // Empty state
                errorText.visibility = View.VISIBLE
                errorText.text = "No coins available"
                recyclerview.visibility = View.GONE
            }
        }
    }
}