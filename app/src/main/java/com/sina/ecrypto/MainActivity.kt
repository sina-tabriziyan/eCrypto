package com.sina.ecrypto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ECryptoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel = koinViewModel<CoinListViewModel>()
                    val state by viewModel.state.collectAsStateWithLifecycle()
                    CoinListScreen(
                        state = state,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}