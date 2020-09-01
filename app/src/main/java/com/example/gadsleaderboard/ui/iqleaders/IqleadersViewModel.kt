package com.example.gadsleaderboard.ui.iqleaders

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.gadsleaderboard.network.TopLearnersClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class IqleadersViewModel : ViewModel() {

    val job = Job()
    val scope = CoroutineScope(job + Dispatchers.Main)

    init {
        getIq()
    }

    private fun getIq() {

        scope.launch {
            val call = TopLearnersClient.topLearnersService.getTopSkillIqAsync()

            val list = call.await()

            Log.d("iq", list.toString())
        }
    }
}