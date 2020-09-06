package com.example.gadsleaderboard.ui.submit

import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.gadsleaderboard.R

class SubmitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)
        setSupportActionBar(findViewById(R.id.submitToolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val actionBar = supportActionBar

        actionBar!!.title = ""



    }
}