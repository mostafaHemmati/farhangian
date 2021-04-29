package com.hemmati.farhangian.domain.model.content

data class VideoListModel(
    val `data`: List<VideoData>,
    val message: String,
    val status: String
)