package com.example.gadsleaderboard.ui.iqleaders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.gadsleaderboard.databinding.IqleadersFragmentBinding
import com.example.gadsleaderboard.ui.adapter.IQListAdapter

class IqleadersFragment : Fragment() {

    companion object {
        fun newInstance() = IqleadersFragment()
    }

    private val viewModel: IqleadersViewModel by lazy {
        ViewModelProviders.of(this).get(IqleadersViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = IqleadersFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this

        binding.viewModel = viewModel
        binding.iqList.adapter = IQListAdapter(IQListAdapter.IqListClickListener {
            Toast.makeText(context, "item ${it.name}", Toast.LENGTH_LONG).show()
        })


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        // TODO: Use the ViewModel
    }

}