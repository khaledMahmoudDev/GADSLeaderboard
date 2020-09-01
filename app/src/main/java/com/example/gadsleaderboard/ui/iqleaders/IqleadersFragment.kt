package com.example.gadsleaderboard.ui.iqleaders

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gadsleaderboard.R

class IqleadersFragment : Fragment() {

    companion object {
        fun newInstance() = IqleadersFragment()
    }

    private lateinit var viewModel: IqleadersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.iqleaders_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(IqleadersViewModel::class.java)


        // TODO: Use the ViewModel
    }

}