package com.hemmati.farhangian.domain.dataaccess.repository

import com.hemmati.farhangian.domain.dataaccess.api.ApiService
import com.hemmati.farhangian.domain.model.category.CategoryModel

interface GetCategoryRepository {
    suspend fun getCategory(): CategoryModel
}

class GetCategoryRepositoryImpl(private val apiService: ApiService) : GetCategoryRepository {
    override suspend fun getCategory(): CategoryModel {
        return apiService.getCategory()
    }
}