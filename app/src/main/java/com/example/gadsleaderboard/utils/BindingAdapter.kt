package com.example.gadsleaderboard.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gadsleaderboard.model.TopSkillIqModel
import com.example.gadsleaderboard.ui.adapter.IQListAdapter

@BindingAdapter("iqBindListAdapter")
fun iqBindListAdapter(recyclerView: RecyclerView, data: List<TopSkillIqModel>?) {
    val adapter = recyclerView.adapter as IQListAdapter
    adapter.submitList(data)

}


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        Glide.with(imgView.context)
            .load(imgUrl)
            .into(imgView)
    }

}