package com.hemmati.farhangian.presentation.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.hemmati.farhangian.R
import com.hemmati.farhangian.presentation.dashboard.podemanPages.Podeman1Fragment
import com.hemmati.farhangian.presentation.dashboard.podemanPages.Podeman2Fragment
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
    }

    private fun initViewPager() {
        val fragmentList = arrayListOf(
            Podeman1Fragment(),
            Podeman2Fragment()
        )

        val viewPagerAdapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        dashboardViewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tab_layout, dashboardViewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.firstPoodeman)
                else -> getString(R.string.secondPoodeman)
            }
        }.attach()
    }

}