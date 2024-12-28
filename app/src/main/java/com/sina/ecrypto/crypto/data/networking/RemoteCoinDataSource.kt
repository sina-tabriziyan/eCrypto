package com.sina.ecrypto.crypto.data.networking

import android.os.Build
import androidx.annotation.RequiresApi
import com.sina.ecrypto.core.data.networkin.constructUrl
import com.sina.ecrypto.core.data.networkin.safeCall
import com.sina.ecrypto.core.domain.util.NetworkError
import com.sina.ecrypto.core.domain.util.Result
import com.sina.ecrypto.core.domain.util.map
import com.sina.ecrypto.crypto.data.mappers.toCoin
import com.sina.ecrypto.crypto.data.mappers.toCoinPrice
import com.sina.ecrypto.crypto.data.networking.dto.CoinHistoryDto
import com.sina.ecrypto.crypto.data.networking.dto.CoinResponseDto
import com.sina.ecrypto.crypto.domain.Coin
import com.sina.ecrypto.crypto.domain.CoinDataSource
import com.sina.ecrypto.crypto.domain.CoinPrice
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.time.ZoneId
import java.time.ZonedDateTime

class RemoteCoinDataSource(
    private val httpClient: HttpClient,
) : CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinResponseDto> {
            httpClient.get(urlString = constructUrl("/assets"))
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        val startMillis = start
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        val endMillis = end
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        return safeCall<CoinHistoryDto> {
            httpClient.get(
                urlString = constructUrl("/assets/$coinId/history")
            ) {
                parameter("interval", "h6")
                parameter("start", startMillis)
                parameter("end", endMillis)
            }
        }.map { response ->
            response.data.map { it.toCoinPrice() }

        }

    }
}