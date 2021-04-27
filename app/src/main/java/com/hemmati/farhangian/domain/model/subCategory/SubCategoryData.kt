package com.hemmati.farhangian.domain.model.subCategory

data class SubCategoryData(
    val id: Int,
    val categoryId: String,
    val subCategoryId: String,
    val subCategoryName: String,
    val subCategoryPic: String,
    val filesCount:Int
)
