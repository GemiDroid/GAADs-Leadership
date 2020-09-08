package com.gemidroid.gaads.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.gemidroid.gaads.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_submission.*
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.net.UnknownHostException

class LearningLeadersFragment : Fragment() {

    private val getLeaderViewModel by sharedViewModel<GetLeaderViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getLeaderViewModel.getLearningLeader.observe(viewLifecycleOwner,
            Observer {
                if (!it.isNullOrEmpty())
                    rec_leaders.apply {
                        adapter = LearningLeaderAdapter(it)
                    }
            })

        getLeaderViewModel.error.observe(viewLifecycleOwner, Observer {
                if (it is UnknownHostException)
                    Snackbar.make(
                        rec_leaders,
                        getString(R.string.no_internet),
                        Snackbar.LENGTH_SHORT).show()
            })

        getLeaderViewModel.status.observe(viewLifecycleOwner,  Observer {
            if(!it)
                progress.visibility = View.GONE
        })
    }
}