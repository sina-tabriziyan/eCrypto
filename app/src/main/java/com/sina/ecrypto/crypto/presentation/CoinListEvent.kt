package com.sina.ecrypto.crypto.presentation

import com.sina.ecrypto.core.domain.util.NetworkError

sealed interface CoinListEvent {
     data class Error(val error: NetworkError): CoinListEvent
}