package com.hemmati.farhangian.domain.dataaccess.api

import com.hemmati.farhangian.domain.model.activation.ActiveUserModel
import com.hemmati.farhangian.domain.model.category.CategoryModel
import com.hemmati.farhangian.domain.model.content.VideoListModel
import com.hemmati.farhangian.domain.model.subCategory.SubCategoryModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("GetCategory.php")
    suspend fun getCategory(): CategoryModel

    @POST("IsActiveUser.php")
    @FormUrlEncoded
    suspend fun isActiveUser(@Field("device_id") deviceId: String): ActiveUserModel

    @POST("GetContentList.php")
    @FormUrlEncoded
    suspend fun getContentList(@Field("sub_category_id") subCategoryId: String): VideoListModel

    @POST("GetSubCategory.php")
    @FormUrlEncoded
    suspend fun getSubCategory(@Field("category_id") categoryId: String): SubCategoryModel

}