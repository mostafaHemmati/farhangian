package com.hemmati.farhangian.domain.model.subCategory

import com.hemmati.farhangian.domain.model.category.Data

data class SubCategoryModel(
    val `data`: List<SubCategoryData>,
    val message: String,
    val status: String
)