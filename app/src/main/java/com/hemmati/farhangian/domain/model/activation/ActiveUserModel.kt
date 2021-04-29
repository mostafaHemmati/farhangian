package com.hemmati.farhangian.domain.model.activation

data class ActiveUserModel(
    val `data`: ActiveUserData? = null,
    val message: String,
    val status: String
)
