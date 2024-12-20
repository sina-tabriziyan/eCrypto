package com.sina.ecrypto.crypto.data.networking

import com.sina.ecrypto.core.data.networkin.constructUrl
import com.sina.ecrypto.core.data.networkin.safeCall
import com.sina.ecrypto.core.domain.util.NetworkError
import com.sina.ecrypto.core.domain.util.Result
import com.sina.ecrypto.core.domain.util.map
import com.sina.ecrypto.crypto.data.mappers.toCoin
import com.sina.ecrypto.crypto.data.networking.dto.CoinResponseDto
import com.sina.ecrypto.crypto.domain.Coin
import com.sina.ecrypto.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient,
) : CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinResponseDto> {
            httpClient.get(urlString = constructUrl("/assets"))
        }.map { response->
            response.data.map { it.toCoin() }
        }
    }
}