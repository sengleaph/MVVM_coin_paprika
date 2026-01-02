package com.sifu.mynotebook.domain.usecase.coinDetails

import com.sifu.mynotebook.domain.model.coinDetail.CoinDetailModel
import com.sifu.mynotebook.domain.repository.coinid.CoinDetailRepository
import com.sifu.mynotebook.util.constance.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinDetailUseCase @Inject constructor(
    private val repository : CoinDetailRepository,
) {
    operator fun invoke(coinId: String): Flow<Resource<List<CoinDetailModel>>> = flow {
        repository.getCoinDetail(coinId).collect { result ->
            when(result){
                is Resource.Loading -> emit(Resource.Loading())
                is Resource.Success -> {
                    val coinDetail = result.data
                    emit(Resource.Success(coinDetail))
                }
                is Resource.Error -> emit(Resource.Error(result.message ?: "Error"))
            }
        }
    }
}