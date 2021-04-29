package com.hemmati.farhangian.presentation.videolist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.hemmati.farhangian.R
import com.hemmati.farhangian.domain.model.content.VideoData
import com.hemmati.farhangian.presentation.videolist.adpater.VideoListAdapter
import com.hemmati.farhangian.util.showToast
import kotlinx.android.synthetic.main.fragment_video_list.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class VideoListFragment : Fragment(R.layout.fragment_video_list) {

    private val viewModel by viewModel<VideoListViewModel> {
        parametersOf(arguments?.getString("subCategoryId", ""))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.error.observe(viewLifecycleOwner) {
            showToast(it)
        }

        viewModel.videoList.observe(viewLifecycleOwner) {
            setupRecyclerView(it)
        }
    }

    private fun setupRecyclerView(list: List<VideoData>) {
        val adapter = VideoListAdapter()
        recyclerView.layoutManager = GridLayoutManager(
            requireContext(),
            5,
            GridLayoutManager.VERTICAL,
            false
        )
        recyclerView.adapter = adapter
        adapter.submitList(list)
    }

}