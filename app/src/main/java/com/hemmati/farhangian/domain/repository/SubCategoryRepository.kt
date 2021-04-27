package com.hemmati.farhangian.domain.repository

import com.hemmati.farhangian.domain.model.activation.ActiveUserModel
import com.hemmati.farhangian.domain.model.subCategory.SubCategoryModel


interface SubCategoryRepository {
    suspend fun getSubCategory(categoryId: String): SubCategoryModel
    suspend fun getUserState(deviceId: String): ActiveUserModel
}