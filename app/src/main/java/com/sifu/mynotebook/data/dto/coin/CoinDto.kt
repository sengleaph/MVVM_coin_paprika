package com.sifu.mynotebook.data.dto.coin

import com.google.gson.annotations.SerializedName

data class CoinDto(
    @SerializedName("id")
    var id: String?,
    @SerializedName("is_active")
    var isActive: Boolean?,
    @SerializedName("is_new")
    var isNew: Boolean?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("rank")
    var rank: Int?,
    @SerializedName("symbol")
    var symbol: String?,
    @SerializedName("type")
    var type: String?
)