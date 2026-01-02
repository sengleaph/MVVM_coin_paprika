package com.sifu.mynotebook.domain.repository.coinid

import com.sifu.mynotebook.domain.model.coinDetail.CoinDetailModel
import com.sifu.mynotebook.util.constance.Resource
import kotlinx.coroutines.flow.Flow

interface CoinDetailRepository {
    fun getCoinDetail(coinId: String): Flow<Resource<List<CoinDetailModel>>>
}