package com.hemmati.farhangian.presentation.dashboard.podemanpages

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.hemmati.farhangian.R
import com.hemmati.farhangian.presentation.dashboard.DashboardViewModel
import com.hemmati.farhangian.presentation.dashboard.adapter.SubCategoryAdapter
import com.hemmati.farhangian.util.getDeviceId
import com.hemmati.farhangian.util.isNetworkAvailable
import com.hemmati.farhangian.util.showIf
import com.hemmati.farhangian.util.showToast
import kotlinx.android.synthetic.main.fragment_podeman.*
import org.koin.android.viewmodel.ext.android.getViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class PoodemanFragment : Fragment(R.layout.fragment_podeman) {

    private lateinit var mSubCategoryAdapter: SubCategoryAdapter
    private val viewModel: PoodemanViewModel by viewModel()
    private val parentViewModel by lazy {
        requireParentFragment().getViewModel<DashboardViewModel>()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialRecyclerView()
        onClicksAction()
        viewModelStartAndObserved()
    }

    private fun viewModelStartAndObserved() {
        if (isNetworkAvailable()) {
            viewModel.subCategorise(arguments?.getString(CATEGORY_ID) ?: "")
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
            viewModel.checkIsActiveUserOrNot(getDeviceId(), {
                parentViewModel.navigateToVideoList(it.subCategoryId)
            }, {
                showToast(getString(R.string.please_enable_app))
            })
        }
    }


    private fun initialRecyclerView() {
        categoryRecyclerView.apply {
            mSubCategoryAdapter = SubCategoryAdapter()
            layoutManager = GridLayoutManager(activity, 2)
            adapter = mSubCategoryAdapter
        }
    }

    companion object {
        const val CATEGORY_ID = "categoryId"
        const val CATEGORY_NAME = "categoryName"
        fun createInstance(categoryId: String, categoryName: String) = PoodemanFragment().apply {
            arguments = bundleOf(
                CATEGORY_ID to categoryId,
                CATEGORY_NAME to categoryName
            )
        }
    }
}