package com.sina.ecrypto

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sina.ecrypto.crypto.presentation.coin_list.CoinListScreen
import com.sina.ecrypto.crypto.presentation.coin_list.CoinListViewModel
import com.sina.ecrypto.ui.theme.ECryptoTheme
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.sina.ecrypto.core.navigation.AdaptiveCoinListDetailPane
import com.sina.ecrypto.core.presentation.util.ObserveAsEvents
import com.sina.ecrypto.core.presentation.util.toString
import com.sina.ecrypto.crypto.presentation.CoinListEvent
import com.sina.ecrypto.crypto.presentation.coin_detail.CoinDetailScreen


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ECryptoTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AdaptiveCoinListDetailPane(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}