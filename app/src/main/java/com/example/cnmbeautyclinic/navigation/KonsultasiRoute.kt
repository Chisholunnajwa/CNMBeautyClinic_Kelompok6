package com.example.cnmbeautyclinic.navigation

import androidx.compose.runtime.Composable
import com.example.cnmbeautyclinic.ui.KonsultasiScreen

@Composable
fun KonsultasiRoute() {
    val backStack = LocalBackStack.current

    KonsultasiScreen {
        backStack.removeLastOrNull()
    }
}