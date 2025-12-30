package com.sifu.mynotebook.data.mapper

import com.sifu.mynotebook.data.dto.CoinDto
import com.sifu.mynotebook.domain.model.CoinModel

fun CoinDto.toDomain(): CoinModel {
    return CoinModel(
        id = id ?: "",
        isActive = isActive ?: true,
        isNew = isNew ?: true,
        name = name ?: "",
        rank = rank ?: 0,
        symbol = symbol ?: "",
        type = type ?: ""
    )
}