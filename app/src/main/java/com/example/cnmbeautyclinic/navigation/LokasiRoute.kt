package com.example.cnmbeautyclinic.navigation

import androidx.compose.runtime.Composable
import com.example.cnmbeautyclinic.ui.LokasiScreen

@Composable
fun LokasiRoute() {
    val backStack = LocalBackStack.current

    LokasiScreen {
        backStack.removeLastOrNull()
    }
}