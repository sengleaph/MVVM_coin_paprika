package com.sifu.mynotebook.domain.model.coinDetail

data class CandleData(
    val open: Float,
    val high: Float,
    val low: Float,
    val close: Float,
    val timestamp: Long = System.currentTimeMillis(),
    val volume: Float = 0f // Optional: trading volume
) {
    val isBullish: Boolean
        get() = close >= open
    
    val priceChange: Float
        get() = close - open
    
    val priceChangePercent: Float
        get() = if (open != 0f) ((close - open) / open) * 100 else 0f
    
    fun isValid(): Boolean {
        return high >= maxOf(open, close) &&
               low <= minOf(open, close) &&
               open > 0 && high > 0 && low > 0 && close > 0
    }
}