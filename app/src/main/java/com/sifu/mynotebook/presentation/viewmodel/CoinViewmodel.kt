package com.sifu.mynotebook.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sifu.mynotebook.domain.usecase.CoinUseCase
import com.sifu.mynotebook.presentation.state.CoinState
import com.sifu.mynotebook.util.constance.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import kotlin.collections.emptyList

@HiltViewModel
class CoinViewmodel @Inject constructor(
    private val coinUseCase: CoinUseCase
): ViewModel() {
    private val _state = MutableStateFlow(CoinState())
    val state: StateFlow<CoinState> = _state

    init{
        getAllCoins()
    }

    private fun getAllCoins() {
        coinUseCase.invoke().onEach { result->
            when(result){
                is Resource.Error -> {
                    _state.value = CoinState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = CoinState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinState(coins = result.data ?: emptyList())
                }
            }
        }.launchIn(scope = viewModelScope)
    }
}