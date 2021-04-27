package com.hemmati.farhangian.data.repository

import com.hemmati.farhangian.data.source.remot.ApiService
import com.hemmati.farhangian.domain.model.activation.ActiveUserModel
import com.hemmati.farhangian.domain.model.subCategory.SubCategoryModel
import com.hemmati.farhangian.domain.repository.SubCategoryRepository

class SubCategoryRepositoryImp(private val apiService: ApiService) : SubCategoryRepository {
    override suspend fun getSubCategory(categoryId: String): SubCategoryModel {
        return apiService.getSubCategory(categoryId)
    }

    override suspend fun getUserState(deviceId: String): ActiveUserModel {
        return apiService.isActiveUser(deviceId)
    }


}