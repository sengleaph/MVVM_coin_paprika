package com.sifu.mynotebook.presentation.state

import com.sifu.mynotebook.domain.model.CoinModel

data class CoinState(
    val isLoading: Boolean = false,
    val coins: List<CoinModel> = emptyList(),
    val error: String = ""
)
