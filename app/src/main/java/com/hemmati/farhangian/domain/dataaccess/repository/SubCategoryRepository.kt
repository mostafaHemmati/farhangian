package com.hemmati.farhangian.domain.dataaccess.repository

import com.hemmati.farhangian.domain.dataaccess.api.ApiService
import com.hemmati.farhangian.domain.model.subCategory.SubCategoryModel

interface SubCategoryRepository {
    suspend fun getSubCategory(categoryId: String): SubCategoryModel
}

class SubCategoryRepositoryImpl(private val apiService: ApiService) : SubCategoryRepository {
    override suspend fun getSubCategory(categoryId: String): SubCategoryModel {
        return apiService.getSubCategory(categoryId)
    }
}