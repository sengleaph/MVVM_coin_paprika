package com.sifu.mynotebook.domain.usecase

import com.sifu.mynotebook.domain.model.CoinModel
import com.sifu.mynotebook.domain.repository.CoinRepository
import com.sifu.mynotebook.util.constance.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<CoinModel>>>{
        return repository.getAllCoins()
    }
}