package com.example.gadsleaderboard.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.gadsleaderboard.R
import com.example.gadsleaderboard.ui.adapter.MainViewPagerAdapter
import com.example.gadsleaderboard.ui.submit.SubmitActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : FragmentActivity() {


    lateinit var viewPager2: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        viewPager2 = findViewById(R.id.pager)

        val pagerAdapter = MainViewPagerAdapter(this)
        viewPager2.adapter = pagerAdapter

        val b = findViewById<Button>(R.id.bbbtn)
        b.setOnClickListener {

            startActivity(Intent(this, SubmitActivity::class.java))
        }


        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {

                    tab.text = getString(R.string.tab1text)
                }
                else -> {
                    tab.text = getString(R.string.tabIqText)
                }
            }

        }.attach()
    }

    override fun onBackPressed() {
        if (viewPager2.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewPager2.currentItem = viewPager2.currentItem - 1
        }
    }

}