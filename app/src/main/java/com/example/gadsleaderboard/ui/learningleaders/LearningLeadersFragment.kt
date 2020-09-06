package com.example.gadsleaderboard.ui.learningleaders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.gadsleaderboard.databinding.LearningLeadersFragmentBinding
import com.example.gadsleaderboard.ui.adapter.LeadersListAdapter
import com.example.gadsleaderboard.ui.adapter.LearningLeadersClickListener

class LearningLeadersFragment : Fragment() {

    companion object {
        fun newInstance() = LearningLeadersFragment()
    }

    private val viewModel: LearningLeadersViewModel by
    lazy {
        ViewModelProviders.of(this).get(LearningLeadersViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = LearningLeadersFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.leadersListRecycler.adapter = LeadersListAdapter(LearningLeadersClickListener {
            Toast.makeText(context, "item ${it.name}", Toast.LENGTH_LONG).show()
        })




        return binding.root

    }


}