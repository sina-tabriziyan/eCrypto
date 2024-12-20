package com.sina.ecrypto.crypto.presentation.models

import androidx.annotation.DrawableRes
import com.sina.ecrypto.crypto.domain.Coin
import com.sina.ecrypto.util.getDrawableIdForCoin
import java.text.NumberFormat
import java.util.Locale

data class CoinUi(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: DisplayableNumber,
    val priceUsd: DisplayableNumber,
    val changePercent24Hr: DisplayableNumber,
    @DrawableRes val iconRes: Int
)

data class DisplayableNumber(
    val value: Double,
    val formatted: String
)

fun Coin.toCoinUi(): CoinUi {
    return CoinUi(
        id = id, name = name,
        symbol = symbol,
        rank = rank,
        priceUsd = priceUsd.toDisplyableNumber(),
        marketCapUsd = marketCapUsd.toDisplyableNumber(),
        changePercent24Hr = changPercent24Hr.toDisplyableNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}


fun Double.toDisplyableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )
}
