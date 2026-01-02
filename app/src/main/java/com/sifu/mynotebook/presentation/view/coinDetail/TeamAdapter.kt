package com.sifu.mynotebook.presentation.view.coinDetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sifu.mynotebook.R
import com.sifu.mynotebook.domain.model.coinDetail.TeamModel

class TeamAdapter : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    private var teamList: List<TeamModel> = emptyList()

    fun updateTeam(newTeam: List<TeamModel>) {
        this.teamList = newTeam
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_info_row, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val member = teamList[position]
        holder.name.text = member.name
        holder.position.text = member.position
    }

    override fun getItemCount() = teamList.size

    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.label)
        val position: TextView = view.findViewById(R.id.value)
    }
}