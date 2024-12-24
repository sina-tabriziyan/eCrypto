package com.sina.ecrypto.di

import com.sina.ecrypto.core.data.networkin.HttpClientFactory
import com.sina.ecrypto.crypto.data.networking.RemoteCoinDataSource
import com.sina.ecrypto.crypto.domain.CoinDataSource
import com.sina.ecrypto.crypto.presentation.coin_list.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }

    singleOf( ::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)

}