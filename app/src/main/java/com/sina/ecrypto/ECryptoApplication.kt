package com.sina.ecrypto

import android.app.Application
import com.sina.ecrypto.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ECryptoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ECryptoApplication)
            androidLogger()

            modules(
                appModule
            )
        }
    }
}