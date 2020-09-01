package com.example.gadsleaderboard.ui.learningleaders

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gadsleaderboard.R

class LearningLeadersFragment : Fragment() {

    companion object {
        fun newInstance() = LearningLeadersFragment()
    }

    private lateinit var viewModel: LearningLeadersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.learning_leaders_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LearningLeadersViewModel::class.java)
        // TODO: Use the ViewModel
    }

}