package com.hemmati.farhangian.domain.model.activation

import com.hemmati.farhangian.domain.model.category.Data

data class ActiveUserModel(
    val `data`: ActiveUserData? = null,
    val message: String,
    val status: String
)
