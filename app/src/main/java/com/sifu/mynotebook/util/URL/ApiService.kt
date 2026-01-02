package com.sifu.mynotebook.util.URL

import com.sifu.mynotebook.data.dto.coin.CoinDto
import com.sifu.mynotebook.data.dto.coinId.CoinDetails
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("coins")
    suspend fun getCoins(): Response<List<CoinDto>>

    @GET("coins/{coinId}")
    suspend fun getCoinById(): Response<List<CoinDetails>>

}


