package com.hemmati.farhangian.presentation.dashboard.podemanPages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.hemmati.farhangian.R
import com.hemmati.farhangian.presentation.dashboard.DashboardViewModel
import com.hemmati.farhangian.presentation.dashboard.SubCategoryAdapter
import com.hemmati.farhangian.util.getDeviceId
import com.hemmati.farhangian.util.isNetworkAvailable
import com.hemmati.farhangian.util.showIf
import com.hemmati.farhangian.util.showToast
import kotlinx.android.synthetic.main.fragment_podeman.*
import org.koin.android.viewmodel.ext.android.viewModel


class Podeman2Fragment : Fragment(R.layout.fragment_podeman) {
    private lateinit var mSubCategoryAdapter: SubCategoryAdapter
    private val viewModel: DashboardViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialRecyclerView()
        onClicksAction()
        viewModelStartAndObserved()
    }

    private fun viewModelStartAndObserved() {

        if (isNetworkAvailable()) {
            viewModel.subCategorise("poodeman2")
            viewModel.getUserState(getDeviceId())
        } else
            showToast(getString(R.string.network_conection_error))

        with(viewModel) {
            subCategoryData.observe(viewLifecycleOwner, {
                mSubCategoryAdapter.itemList = it.data
            })
            showProgressbar.observe(viewLifecycleOwner, { state ->
                progressBar.showIf { state }
            })
            messageData.observe(viewLifecycleOwner, { errorMsg ->
                showToast(errorMsg)
            })

        }
    }

    private fun onClicksAction() {
        mSubCategoryAdapter.onItemClick = {
            viewModel.userStateData.observe(viewLifecycleOwner, { result ->
                showToast(it.filesCount.toString())
//              todo  save user state
            })
//todo if (user is active and video list not empty) goto video list fragment
//            todo bundle = sub_category_id
        }
    }


    private fun initialRecyclerView() {
        categoryRecyclerView.apply {
            mSubCategoryAdapter = SubCategoryAdapter()
            layoutManager = GridLayoutManager(activity, 2)
            adapter = mSubCategoryAdapter
        }
    }

}