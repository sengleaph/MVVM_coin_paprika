package com.sifu.mynotebook.presentation.view.coinDetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sifu.mynotebook.R
import com.sifu.mynotebook.domain.model.coinDetail.CoinDetailModel

/**
 * CoinAdapter - Use this adapter when displaying a LIST of coins
 * For displaying team members, use TeamAdapter instead
 */
class CoinAdapter : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    private var coinList: List<CoinDetailModel> = emptyList()

    fun updateCoins(newCoins: List<CoinDetailModel>) {
        this.coinList = newCoins
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_info_row, parent, false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = coinList[position]
        holder.name.text = coin.name
        holder.rank.text = "#${coin.rank}"
    }

    override fun getItemCount() = coinList.size

    class CoinViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.label)
        val rank: TextView = view.findViewById(R.id.value)
    }
}