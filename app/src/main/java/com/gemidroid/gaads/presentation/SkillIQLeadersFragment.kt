package com.gemidroid.gaads.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.gemidroid.gaads.R
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SkillIQLeadersFragment : Fragment() {

    private val getLeaderViewModel by sharedViewModel<GetLeaderViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getLeaderViewModel.getSkillIQLeader.observe(viewLifecycleOwner,
            Observer {
                if(!it.isNullOrEmpty())
                    rec_leaders.apply {
                        adapter = SkillIQLeaderAdapter(it)
                    }
            })

        getLeaderViewModel.status.observe(viewLifecycleOwner,  Observer {
            if(!it)
                progress.visibility = View.GONE
        })
    }
}