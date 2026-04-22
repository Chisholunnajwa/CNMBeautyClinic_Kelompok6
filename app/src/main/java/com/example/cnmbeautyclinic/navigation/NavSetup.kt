package com.example.cnmbeautyclinic.navigation

import androidx.compose.runtime.*

val LocalBackStack = compositionLocalOf<MutableList<Screen>> {
    error("BackStack not provided")
}

@Composable
fun NavDisplay() {
    val backStack = LocalBackStack.current
    val current = backStack.last()

    when (current) {
        is Screen.Welcome -> WelcomeRoute()
        is Screen.Menu -> MenuRoute()
        is Screen.Konsultasi -> KonsultasiRoute()
        is Screen.Pricelist -> PricelistRoute()
        is Screen.Detail -> DetailRoute(current.nama, current.harga)
        is Screen.Lokasi -> LokasiRoute()
    }
}