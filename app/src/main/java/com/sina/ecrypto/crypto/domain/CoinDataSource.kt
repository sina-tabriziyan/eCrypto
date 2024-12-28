package com.sina.ecrypto.crypto.domain

import com.sina.ecrypto.core.domain.util.NetworkError
import com.sina.ecrypto.core.domain.util.Result
import java.time.ZonedDateTime

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>

    suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError>
}

data class CoinPrice(
    val priceUsd: Double,
    val dateTime: ZonedDateTime?
)