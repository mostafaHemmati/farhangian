package com.hemmati.farhangian.presentation.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.hemmati.farhangian.R
import com.hemmati.farhangian.domain.model.category.CategoryData
import com.hemmati.farhangian.presentation.dashboard.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_dashboard.*
import org.koin.android.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val viewModel: DashboardViewModel by viewModel<DashboardViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        initActivationButton()
    }

    private fun observeViewModel() {
        viewModel.submitFragmentList.observe(viewLifecycleOwner) {
            initViewPager(it)
        }

        viewModel.navigateToVideoList.observe(viewLifecycleOwner) {
            findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToVideoListFragment())
        }
    }

    private fun initViewPager(categories: List<CategoryData>) {
        val viewPagerAdapter = ViewPagerAdapter(
            categories,
            this
        )
        dashboardViewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tab_layout, dashboardViewPager) { tab, position ->
            tab.text = viewModel.submitFragmentList.value?.get(position)?.categoryName ?: ""
        }.attach()
    }

    private fun initActivationButton() {
        btnActivationGuide.setOnClickListener {
            findNavController().navigate(
                DashboardFragmentDirections.actionDashboardFragmentToActivationDialogFragment()
            )
        }
    }

}