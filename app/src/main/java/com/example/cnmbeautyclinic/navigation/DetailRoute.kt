package com.example.cnmbeautyclinic.navigation

import androidx.compose.runtime.Composable
import com.example.cnmbeautyclinic.ui.DetailScreen

@Composable
fun DetailRoute(nama: String, harga: String) {
    val backStack = LocalBackStack.current

    DetailScreen(
        nama = nama,
        harga = harga,
        onBackToMenu = {
            backStack.clear()
            backStack.add(Screen.Menu)
        }
    )
}