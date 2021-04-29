package com.hemmati.farhangian.domain.dataaccess.repository

import com.hemmati.farhangian.domain.dataaccess.api.ApiService
import com.hemmati.farhangian.domain.model.content.VideoListModel

interface GetVideoListRepository {
    suspend fun getVideoList(subCategoryId: String): VideoListModel
}

class GetVideoListRepositoryImpl(private val apiService: ApiService) : GetVideoListRepository {
    override suspend fun getVideoList(subCategoryId: String): VideoListModel {
        return apiService.getContentList(subCategoryId)
    }

}