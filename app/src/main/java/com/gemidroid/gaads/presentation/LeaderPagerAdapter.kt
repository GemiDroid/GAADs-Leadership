package com.gemidroid.gaads.presentation

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.gemidroid.gaads.R

private val TAB_TITLES = arrayOf(
        R.string.learning_leader,
        R.string.skilliq_leader)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {


    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getItem(position: Int): Fragment {
      return  when(position){
            0-> LearningLeadersFragment()
          else -> SkillIQLeadersFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }
}