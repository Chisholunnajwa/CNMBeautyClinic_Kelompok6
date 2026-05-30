package com.example.cnmbeautyclinic.navigation

sealed class Screen {

    object Login : Screen()

    object Register : Screen()

    object Welcome : Screen()

    object Menu : Screen()

    object Konsultasi : Screen()

    object Pricelist : Screen()

    object Lokasi : Screen()

    object Treatment : Screen()

    data class Detail(
        val nama: String,
        val harga: String,
        val deskripsi: String,
        val manfaat: String
    ) : Screen()
}

