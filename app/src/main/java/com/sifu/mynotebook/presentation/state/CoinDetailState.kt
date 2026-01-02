package com.sifu.mynotebook.presentation.state

import com.sifu.mynotebook.domain.model.coin.CoinModel
import com.sifu.mynotebook.domain.model.coinDetail.CoinDetailModel

class CoinDetailState (
    val isLoading: Boolean = false,
    val coins: List<CoinDetailModel> = emptyList(),
    val error: String = ""
)