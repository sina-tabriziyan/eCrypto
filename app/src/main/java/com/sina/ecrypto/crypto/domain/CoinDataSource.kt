package com.sina.ecrypto.crypto.domain

import com.sina.ecrypto.core.domain.util.NetworkError
import com.sina.ecrypto.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}