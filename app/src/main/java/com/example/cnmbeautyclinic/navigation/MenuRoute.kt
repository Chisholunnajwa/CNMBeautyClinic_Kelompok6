package com.example.cnmbeautyclinic.navigation

import androidx.compose.runtime.Composable
import com.example.cnmbeautyclinic.ui.MenuScreen

@Composable
fun MenuRoute() {
    val backStack = LocalBackStack.current

    MenuScreen(
        onKonsultasi = { backStack.add(Screen.Konsultasi) },
        onPrice = { backStack.add(Screen.Pricelist) },
        onLokasi = { backStack.add(Screen.Lokasi) }
    )
}