package com.sifu.mynotebook.data.repository.coinId

import com.sifu.mynotebook.data.mapper.toDomain
import com.sifu.mynotebook.domain.model.coinDetail.CoinDetailModel
import com.sifu.mynotebook.domain.repository.coinid.CoinDetailRepository
import com.sifu.mynotebook.util.URL.ApiService
import com.sifu.mynotebook.util.constance.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.collections.map

class CoinDetailRepositoryIMPL @Inject constructor(
    private val apiService: ApiService
): CoinDetailRepository {
    override fun getCoinDetail(id: String): Flow<Resource<List<CoinDetailModel>>> = flow {
        try {
            emit(Resource.Loading())
            val response = apiService.getCoinById()
            if (response.isSuccessful && response.body() != null) {
                val coinsDetail = response.body()!!.map { it.toDomain() }
                emit(Resource.Success(coinsDetail))
            } else {
                emit(Resource.Error(response.message()))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}