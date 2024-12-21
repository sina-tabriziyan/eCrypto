package com.sina.ecrypto.crypto.presentation.coin_list

import com.sina.ecrypto.crypto.presentation.models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi) : CoinListAction
//    data object OnRefresh: CoinListAction
}