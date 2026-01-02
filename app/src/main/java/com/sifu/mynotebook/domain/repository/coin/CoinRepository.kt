package com.sifu.mynotebook.domain.repository.coin

import com.sifu.mynotebook.domain.model.coin.CoinModel
import com.sifu.mynotebook.util.constance.Resource
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    fun getAllCoins(): Flow<Resource<List<CoinModel>>>
}