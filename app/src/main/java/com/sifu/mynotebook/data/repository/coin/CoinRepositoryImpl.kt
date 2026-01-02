package com.sifu.mynotebook.data.repository.coin

import com.sifu.mynotebook.data.mapper.toDomain
import com.sifu.mynotebook.domain.model.coin.CoinModel
import com.sifu.mynotebook.domain.repository.coin.CoinRepository
import com.sifu.mynotebook.util.URL.ApiService
import com.sifu.mynotebook.util.constance.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): CoinRepository {
    override fun getAllCoins(): Flow<Resource<List<CoinModel>>> = flow {
        try {
            emit(Resource.Loading())
            val response = apiService.getCoins()
            if (response.isSuccessful && response.body() != null) {
                val coins = response.body()!!.map { it.toDomain() }
                emit(Resource.Success(coins))
            } else {
                emit(Resource.Error(response.message()))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}