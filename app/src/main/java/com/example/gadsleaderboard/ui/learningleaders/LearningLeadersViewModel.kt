package com.example.gadsleaderboard.ui.learningleaders

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.gadsleaderboard.network.TopLearnersClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LearningLeadersViewModel : ViewModel() {
    val job = Job()
    val scope = CoroutineScope(job + Dispatchers.Main)

    init {
        getTopLearners()
    }

    private fun getTopLearners() {

        scope.launch {
            val call = TopLearnersClient.topLearnersService.getTopLearningLeadersAsync()

            val list = call.await()

            Log.d("learners", list.toString())
        }
    }
}