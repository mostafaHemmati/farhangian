package com.hemmati.farhangian.domain.model.content

import com.hemmati.farhangian.domain.model.category.Data

data class ContentListModel(
    val `data`: List<ContentData>,
    val message: String,
    val status: String
)