package com.hemmati.farhangian.presentation.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.hemmati.farhangian.R
import com.hemmati.farhangian.presentation.dashboard.podemanPages.Podeman1Fragment
import com.hemmati.farhangian.presentation.dashboard.podemanPages.Podeman2Fragment
import com.hemmati.farhangian.util.showToast
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val fragmentList = arrayListOf(
            Podeman1Fragment(),
            Podeman2Fragment()
        )
        val viewPagerAdapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        view.dashboardViewPager.adapter = viewPagerAdapter

        TabLayoutMediator(view.tab_layout, view.dashboardViewPager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.firstPoodeman)
                else -> getString(R.string.secondPoodeman)
            }
        }.attach()

        return view
    }

}