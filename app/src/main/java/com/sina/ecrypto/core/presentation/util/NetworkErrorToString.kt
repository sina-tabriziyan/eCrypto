package com.sina.ecrypto.core.presentation.util

import android.content.Context
import com.sina.ecrypto.R
import com.sina.ecrypto.core.domain.util.NetworkError

fun NetworkError.toString(context: Context): String = context.getString(
    when (this) {
        NetworkError.REQUEST_TIMEOUT -> R.string.error_request_timeout
        NetworkError.TOO_MANY_REQUEST -> R.string.error_request_timeout
        NetworkError.NO_INTERNET -> R.string.error_request_timeout
        NetworkError.SERVER_ERROR -> R.string.error_request_timeout
        NetworkError.SERIALIZATION -> R.string.error_request_timeout
        NetworkError.UNKNOWN -> R.string.error_request_timeout
    }
)
