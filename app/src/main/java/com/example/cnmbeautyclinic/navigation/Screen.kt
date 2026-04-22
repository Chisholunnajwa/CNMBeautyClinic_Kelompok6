package com.example.cnmbeautyclinic.navigation

sealed class Screen {
    object Welcome : Screen()
    object Menu : Screen()
    object Konsultasi : Screen()
    object Pricelist : Screen()
    object Lokasi : Screen()
    data class Detail(val nama: String, val harga: String) : Screen()
}