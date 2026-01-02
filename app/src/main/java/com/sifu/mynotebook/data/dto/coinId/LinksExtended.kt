package com.sifu.mynotebook.data.dto.coinId


import com.google.gson.annotations.SerializedName

data class LinksExtended(
    @SerializedName("stats")
    val stats: ArrayList<Stats>?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)