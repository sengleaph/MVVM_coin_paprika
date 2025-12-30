package com.sifu.mynotebook.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sifu.mynotebook.R
import com.sifu.mynotebook.databinding.CardItemBinding
import com.sifu.mynotebook.domain.model.CoinModel

class CoinAdapter(
    private val coins: List<CoinModel>
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
            }
        }
    }

   /* inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageview: ImageView = view.findViewById(R.id.imageview)
        private val nameText: TextView = view.findViewById(R.id.nameText)
        private val rankNumber: TextView = view.findViewById(R.id.rankNumber)
        private val typeText: TextView = view.findViewById(R.id.typeText)
        private val isActive: TextView = view.findViewById(R.id.isActive)
        private val isNew: View = view.findViewById(R.id.isNew)

        fun bind(coin: CoinModel) {
            imageview.setImageResource(R.drawable.ic_profile)
            nameText.text = coin.name
            rankNumber.text = coin.rank.toString()
            typeText.text = coin.type
            isActive.text = if(coin.isActive) "Active" else "Inactive"
            isNew.visibility = if(coin.isNew) View.VISIBLE else View.GONE
        }
    }*/

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