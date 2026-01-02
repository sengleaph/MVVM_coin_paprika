package com.sifu.mynotebook.domain.usecase.coin

import com.sifu.mynotebook.domain.model.coin.CoinModel
import com.sifu.mynotebook.domain.repository.coin.CoinRepository
import com.sifu.mynotebook.util.constance.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<CoinModel>>> = flow {
        repository.getAllCoins().collect { result ->
            when (result) {
                is Resource.Loading -> emit(Resource.Loading())
                is Resource.Success -> {
                    // Add any business logic here (filtering, sorting, etc.)
                    val processedCoins = result.data // Apply transformations if needed
                    emit(Resource.Success(processedCoins))
                }

                is Resource.Error -> emit(Resource.Error(result.message ?: "Error"))
            }

        }
    }
}