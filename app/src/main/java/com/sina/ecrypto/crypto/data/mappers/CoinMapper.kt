package com.sina.ecrypto.crypto.data.mappers

import com.sina.ecrypto.crypto.data.networking.dto.CoinDto
import com.sina.ecrypto.crypto.domain.Coin

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changPercent24Hr = changePercent24Hr
    )
}