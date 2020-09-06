package com.example.gadsleaderboard.ui.learningleaders

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gadsleaderboard.model.TopLearningLeaderModel
import com.example.gadsleaderboard.network.TopLearnersClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LearningLeadersViewModel : ViewModel() {
    val job = Job()
    val scope = CoroutineScope(job + Dispatchers.Main)

    private val _leadersList = MutableLiveData<List<TopLearningLeaderModel>>()

    val leadersList: LiveData<List<TopLearningLeaderModel>>
        get() = _leadersList

    init {
        getTopLearners()
    }

    private fun getTopLearners() {

        scope.launch {
            val call = TopLearnersClient.topLearnersService.getTopLearningLeadersAsync()

            val list = call.await()

            if (!list.isNullOrEmpty()) {
                _leadersList.value = list
                Log.d("leader before", list.toString())
            }

        }
    }
}