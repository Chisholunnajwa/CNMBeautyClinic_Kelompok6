package com.example.cnmbeautyclinic.navigation

import androidx.compose.runtime.Composable
import com.example.cnmbeautyclinic.ui.PricelistScreen

@Composable
fun PricelistRoute() {
    val backStack = LocalBackStack.current

    PricelistScreen(
        onBackToMenu = {
            backStack.clear()
            backStack.add(Screen.Menu)
        },
        onDetail = { nama, harga ->
            backStack.add(Screen.Detail(nama, harga))
        }
    )
}