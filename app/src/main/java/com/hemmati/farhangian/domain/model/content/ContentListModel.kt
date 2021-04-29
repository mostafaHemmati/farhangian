package com.hemmati.farhangian.domain.model.content

data class ContentListModel(
    val `data`: List<ContentData>,
    val message: String,
    val status: String
)