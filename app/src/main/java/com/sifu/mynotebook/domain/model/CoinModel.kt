package com.sifu.mynotebook.domain.model

import com.google.gson.annotations.SerializedName

class CoinModel (
    var id: String = "",
    var isActive: Boolean = true,
    var isNew: Boolean = true,
    var name: String = "",
    var rank: Int = 0,
    var symbol: String = "",
    var type: String = ""
)