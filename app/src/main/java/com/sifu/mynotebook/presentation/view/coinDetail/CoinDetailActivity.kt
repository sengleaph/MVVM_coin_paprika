package com.sifu.mynotebook.presentation.view.coinDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.sifu.mynotebook.R
import com.sifu.mynotebook.domain.model.coinDetail.CoinDetailModel
import com.sifu.mynotebook.presentation.viewmodel.coinDetail.CoinDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CoinDetailActivity : AppCompatActivity() {

    private val viewModel: CoinDetailViewModel by viewModels()
    private val teamAdapter = TeamAdapter() // ✅ CORRECT: TeamAdapter for team members

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)

        setupRecyclerView()
        loadCoinData()
        observeState()
    }

    private fun setupRecyclerView() {
        findViewById<RecyclerView>(R.id.rvTeam).apply {
            layoutManager = LinearLayoutManager(this@CoinDetailActivity)
            adapter = teamAdapter
        }
    }

    private fun loadCoinData() {
        val coinId = intent.getStringExtra(EXTRA_COIN_ID)
        if (coinId != null) {
            viewModel.getCoinDetail(coinId)
        } else {
            showError("Coin ID not found")
            finish()
        }
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    when {
                        state.isLoading -> showLoading(true)
                        state.error.isNotBlank() -> showError(state.error)
                        state.coins.isNotEmpty() -> {
                            showLoading(false)
                            bindCoinData(state.coins[0])
                        }
                    }
                }
            }
        }
    }

    private fun bindCoinData(coin: CoinDetailModel) {
        // Basic coin info
        findViewById<TextView>(R.id.tvName).text = "${coin.name} (${coin.symbol})"
        findViewById<TextView>(R.id.tvDescription).text = coin.description

        // Optional: Display more coin details
        // findViewById<TextView>(R.id.tvRank).text = "Rank: #${coin.rank}"
        // findViewById<TextView>(R.id.tvType).text = coin.type
        // Glide.with(this).load(coin.logo).into(findViewById(R.id.imgLogo))

        // ✅ CORRECT: Update team RecyclerView with ArrayList<TeamModel>
        teamAdapter.updateTeam(coin.team)

        // Add Tags to ChipGroup
        val chipGroup = findViewById<ChipGroup>(R.id.tagGroup)
        chipGroup.removeAllViews()
        coin.tags.forEach { tag ->
            val chip = Chip(this).apply {
                text = tag.name
                isClickable = false
                isCheckable = false
            }
            chipGroup.addView(chip)
        }
    }

    private fun showLoading(isLoading: Boolean) {
        findViewById<ProgressBar>(R.id.progressBar).isVisible = isLoading
    }

    private fun showError(message: String) {
        showLoading(false)
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    companion object {
        private const val EXTRA_COIN_ID = "extra_coin_id"

        fun newIntent(context: Context, coinId: String): Intent {
            return Intent(context, CoinDetailActivity::class.java).apply {
                putExtra(EXTRA_COIN_ID, coinId)
            }
        }
    }
}