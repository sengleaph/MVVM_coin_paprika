package com.sifu.mynotebook.util.URL

import com.sifu.mynotebook.data.dto.CoinDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("coins")
    suspend fun getCoins(): Response<List<CoinDto>>
}