package com.hemmati.farhangian.presentation.videolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hemmati.farhangian.domain.exeption.ApiError
import com.hemmati.farhangian.domain.model.content.VideoData
import com.hemmati.farhangian.domain.model.content.VideoListModel
import com.hemmati.farhangian.domain.usecase.GetVideoListUseCase
import com.hemmati.farhangian.domain.usecase.base.UseCaseResponse

class VideoListViewModel(
    private val getVideoListUseCase: GetVideoListUseCase,
    private val subCategoryId: String
) : ViewModel() {

    private val _videoList = MutableLiveData<List<VideoData>>()
    val videoList: LiveData<List<VideoData>> get() = _videoList

    private val _error = MutableLiveData<String>()
    val error:LiveData<String> get() = _error

    init {
        getVideoList()
    }

    private fun getVideoList() {
        getVideoListUseCase.invoke(
            viewModelScope,
            subCategoryId,
            object : UseCaseResponse<VideoListModel> {
                override fun onSuccess(result: VideoListModel) {
                    _videoList.value = result.data
                }

                override fun onError(apiError: ApiError?) {
                    _error.value = apiError?.message
                }
            })
    }

}