package com.sojann.focusbro.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import com.sojann.focusbro.presentation.home.HomeScreen
import com.sojann.focusbro.presentation.home.HomeScreenPreview
import com.sojann.focusbro.presentation.home.HomeScreenViewModel
import com.sojann.focusbro.ui.theme.FocusBroTheme

internal val viewModel  : HomeScreenViewModel = HomeScreenViewModel()
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowsSize = calculateWindowSizeClass(activity = this)
            FocusBroTheme(
                windowsSize = windowsSize.widthSizeClass
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ){
                    HomeScreen(viewModel)
                }
            }
        }
    }
}

