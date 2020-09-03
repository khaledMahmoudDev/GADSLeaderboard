package com.example.gadsleaderboard.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gadsleaderboard.databinding.IqSkillRowElementBinding
import com.example.gadsleaderboard.model.TopSkillIqModel

class IQListAdapter(private val iqListClickListener: IqListClickListener) :
    ListAdapter<TopSkillIqModel, IQListAdapter.TopSkillIqViewHolder>(IqDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopSkillIqViewHolder {
        return TopSkillIqViewHolder(IqSkillRowElementBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TopSkillIqViewHolder, position: Int) {
        holder.bind(getItem(position), iqListClickListener)
    }


    class TopSkillIqViewHolder(var binding: IqSkillRowElementBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(topSkillIQ: TopSkillIqModel, clickListener: IqListClickListener) {
            binding.iqElement = topSkillIQ
            binding.clickListener = clickListener
            binding.executePendingBindings()

        }

    }


    companion object IqDiffUtil : DiffUtil.ItemCallback<TopSkillIqModel>() {
        override fun areItemsTheSame(oldItem: TopSkillIqModel, newItem: TopSkillIqModel): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: TopSkillIqModel,
            newItem: TopSkillIqModel
        ): Boolean {
            return oldItem == newItem
        }

    }

    class IqListClickListener(val clickListener: (topSkilIQ: TopSkillIqModel) -> Unit) {
        fun onClick(topSkillIQ: TopSkillIqModel) = clickListener(topSkillIQ)

    }


}

