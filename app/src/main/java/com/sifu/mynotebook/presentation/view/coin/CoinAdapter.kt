package com.sifu.mynotebook.presentation.view.coin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sifu.mynotebook.R
import com.sifu.mynotebook.databinding.CardItemBinding
import com.sifu.mynotebook.domain.model.coin.CoinModel

class CoinAdapter(
    private val coins: List<CoinModel>,
    private val onCoinClick: (String) -> Unit
): RecyclerView.Adapter<CoinAdapter.ViewHolder>()  {
    inner class ViewHolder(private val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(coin: CoinModel) {
            binding.apply{
                imageview.setImageResource(R.drawable.ic_profile)
                nameText.text = coin.name
                rankNumber.text = coin.rank.toString()
                typeText.text = coin.type
                isActive.text = if(coin.isActive) "active" else "inactive"
                isNew.visibility = if(coin.isNew) View.VISIBLE else View.GONE
                // Set click listener
                root.setOnClickListener {
                    onCoinClick(coin.id)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(coins[position])
    }

    override fun getItemCount(): Int {
        return coins.size
    }
}