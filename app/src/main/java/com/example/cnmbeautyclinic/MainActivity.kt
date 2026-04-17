package com.example.cnmbeautyclinic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.cnmbeautyclinic.navigation.Screen
import com.example.cnmbeautyclinic.ui.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val backStack = remember { mutableStateListOf<Screen>(Screen.Welcome) }
            val current = backStack.last()

            when (current) {

                is Screen.Welcome -> WelcomeScreen {
                    backStack.add(Screen.Menu)
                }

                is Screen.Menu -> MenuScreen(
                    onKonsultasi = { backStack.add(Screen.Konsultasi) },
                    onPrice = { backStack.add(Screen.Pricelist) },
                    onLokasi = { backStack.add(Screen.Lokasi) }
                )

                is Screen.Konsultasi -> KonsultasiScreen {
                    backStack.removeLastOrNull()
                }

                // 🔥 PRICELIST → BALIK KE MENU LANGSUNG
                is Screen.Pricelist -> PricelistScreen(
                    onBackToMenu = {
                        backStack.clear()
                        backStack.add(Screen.Menu)
                    },
                    onDetail = { nama: String, harga: String ->
                        backStack.add(Screen.Detail(nama, harga))
                    }
                )

                // 🔥 DETAIL → BOOKING BALIK KE MENU
                is Screen.Detail -> DetailScreen(
                    nama = current.nama,
                    harga = current.harga,
                    onBackToMenu = {
                        backStack.clear()
                        backStack.add(Screen.Menu)
                    }
                )

                is Screen.Lokasi -> LokasiScreen {
                    backStack.removeLastOrNull()
                }
            }
        }
    }
}