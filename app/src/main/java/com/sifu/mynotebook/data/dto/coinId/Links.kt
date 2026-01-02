package com.sifu.mynotebook.data.dto.coinId


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("explorer")
    val explorer: ArrayList<String>?,
    @SerializedName("facebook")
    val facebook: ArrayList<String>?,
    @SerializedName("reddit")
    val reddit: ArrayList<String>?,
    @SerializedName("source_code")
    val sourceCode: ArrayList<String>?,
    @SerializedName("website")
    val website: ArrayList<String>?,
    @SerializedName("youtube")
    val youtube: ArrayList<String>?
)