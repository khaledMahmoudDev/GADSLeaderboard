package com.example.gadsleaderboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gadsleaderboard.databinding.LeadersRowElementBinding
import com.example.gadsleaderboard.model.TopLearningLeaderModel

class LeadersListAdapter(val listener: LearningLeadersClickListener) :
    ListAdapter<TopLearningLeaderModel, LeadersListAdapter.LearningLeadersViewHolder>(
        LeasersLearningDiffUtil()
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearningLeadersViewHolder {
        return LearningLeadersViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LearningLeadersViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }


    class LearningLeadersViewHolder private constructor(val binding: LeadersRowElementBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(leader: TopLearningLeaderModel, clickListener: LearningLeadersClickListener) {
            binding.leader = leader
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): LearningLeadersViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LeadersRowElementBinding.inflate(layoutInflater, parent, false)
                return LearningLeadersViewHolder(binding)

            }
        }
    }


}

class LearningLeadersClickListener(val clickListener: (leader: TopLearningLeaderModel) -> Unit) {
    fun onItemClick(leader: TopLearningLeaderModel) = clickListener(leader)

}

class LeasersLearningDiffUtil : DiffUtil.ItemCallback<TopLearningLeaderModel>() {
    override fun areItemsTheSame(
        oldItem: TopLearningLeaderModel,
        newItem: TopLearningLeaderModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: TopLearningLeaderModel,
        newItem: TopLearningLeaderModel
    ): Boolean {
        return oldItem == newItem
    }


}