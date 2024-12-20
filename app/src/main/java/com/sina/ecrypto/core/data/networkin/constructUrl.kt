package com.sina.ecrypto.core.data.networkin

import android.os.Build
import com.sina.ecrypto.BuildConfig

fun constructUrl(url: String): String = when {
    url.contains(BuildConfig.BASE_URL) -> url
    url.startsWith("/") -> BuildConfig.BASE_URL + url.drop(1)
    else -> BuildConfig.BASE_URL + url
}