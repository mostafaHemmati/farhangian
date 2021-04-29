package com.hemmati.farhangian.domain.model.content

data class VideoData(
    val id: Int,
    val subCategoryId: String,
    val videoName: String,
    val videoUrl: String,
    val videoPic: String
)