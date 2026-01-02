package com.sifu.mynotebook.domain.model.coinDetail

import com.google.gson.annotations.SerializedName

data class LinksModel(
    val explorer: ArrayList<String>,
    val facebook: ArrayList<String>,
    val reddit: ArrayList<String>,
    val sourceCode: ArrayList<String>,
    val website: ArrayList<String>,
    val youtube: ArrayList<String>
)
