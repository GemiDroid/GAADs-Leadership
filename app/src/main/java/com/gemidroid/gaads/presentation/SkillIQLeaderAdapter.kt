package com.gemidroid.gaads.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gemidroid.gaads.R
import com.gemidroid.gaads.data.model.leader.SkillIQ
import kotlinx.android.synthetic.main.leader_item.view.*

class SkillIQLeaderAdapter(
    private val skillIQLeaders: List<SkillIQ>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val root = LayoutInflater.from(parent.context)
            .inflate(R.layout.leader_item, parent, false)
        return object : RecyclerView.ViewHolder(root) {}
    }

    override fun getItemCount(): Int {
        return skillIQLeaders.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = skillIQLeaders[position]
        Glide.with(holder.itemView.context)
            .load(item.badgeUrl)
            .into(holder.itemView.img_badge)
        holder.itemView.apply {
            txt_name.text = item.name
            txt_hours_city.text = "${item.scores} Skill IQ Score, ${item.country}"
        }
    }

}
