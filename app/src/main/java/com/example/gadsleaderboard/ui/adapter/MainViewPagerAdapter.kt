package com.example.gadsleaderboard.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gadsleaderboard.ui.iqleaders.IqleadersFragment
import com.example.gadsleaderboard.ui.learningleaders.LearningLeadersFragment


private const val NUM_PAGES = 2

class MainViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> LearningLeadersFragment()
        else -> IqleadersFragment()
    }


}