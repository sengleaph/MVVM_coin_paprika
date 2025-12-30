package com.sifu.mynotebook.domain.repository

import com.sifu.mynotebook.data.dto.CoinDto
import com.sifu.mynotebook.domain.model.CoinModel
import com.sifu.mynotebook.util.URL.ApiService
import com.sifu.mynotebook.util.constance.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CoinRepository {
    fun getAllCoins(): Flow<Resource<List<CoinModel>>>
}