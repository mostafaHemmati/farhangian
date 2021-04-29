package com.hemmati.farhangian.domain.usecase

import com.hemmati.farhangian.domain.dataaccess.repository.GetVideoListRepository
import com.hemmati.farhangian.domain.model.content.VideoListModel
import com.hemmati.farhangian.domain.usecase.base.UseCase

class GetVideoListUseCase(
    private val getVideoListRepository: GetVideoListRepository
) : UseCase<VideoListModel, Any?>() {
    override suspend fun run(params: Any?): VideoListModel {
        return getVideoListRepository.getVideoList(params.toString())
    }
}