package com.sifu.mynotebook.domain.model.coinDetail


data class LinksExtendedModel(
    val stats: ArrayList<StatsModel>?,
    val type: String = "",
    val url: String = ""
)
