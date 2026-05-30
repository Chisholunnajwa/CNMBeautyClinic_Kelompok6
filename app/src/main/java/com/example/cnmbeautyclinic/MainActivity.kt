package com.example.cnmbeautyclinic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.platform.LocalContext
import com.example.cnmbeautyclinic.data.SessionManager
import com.example.cnmbeautyclinic.navigation.Screen
import com.example.cnmbeautyclinic.ui.LoginScreen
import com.example.cnmbeautyclinic.ui.MenuScreen
import com.example.cnmbeautyclinic.ui.RegisterScreen
import com.example.cnmbeautyclinic.ui.screen.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val context = LocalContext.current
            val sessionManager = SessionManager(context)

            val startScreen =
                if (sessionManager.isLoggedIn()) {
                    Screen.Menu
                } else {
                    Screen.Login
                }

            val backStack = remember {
                mutableStateListOf<Screen>(startScreen)
            }

            val current = backStack.last()

            when (current) {

                // LOGIN
                is Screen.Login -> LoginScreen(

                    onLoginClick = {

                        sessionManager.saveLogin(
                            "User",
                            "user@gmail.com"
                        )

                        backStack.clear()
                        backStack.add(Screen.Welcome)
                    },

                    onRegisterClick = {
                        backStack.add(Screen.Register)
                    }
                )

                // REGISTER
                is Screen.Register -> RegisterScreen(

                    onRegisterSuccess = {

                        backStack.clear()
                        backStack.add(Screen.Login)
                    },

                    onBackLogin = {
                        backStack.removeLastOrNull()
                    }
                )

                // WELCOME
                is Screen.Welcome -> WelcomeScreen(

                    onNext = {
                        backStack.add(Screen.Menu)
                    }
                )

                // MENU
                is Screen.Menu -> MenuScreen(

                    onKonsultasi = {
                        backStack.add(Screen.Konsultasi)
                    },

                    onPrice = {
                        backStack.add(Screen.Pricelist)
                    },

                    onLokasi = {
                        backStack.add(Screen.Lokasi)
                    },

                    onTreatment = {
                        backStack.add(Screen.Treatment)
                    },

                    onLogout = {

                        sessionManager.logout()

                        backStack.clear()
                        backStack.add(Screen.Login)
                    }
                )

                // KONSULTASI
                is Screen.Konsultasi -> KonsultasiScreen(

                    onBack = {
                        backStack.removeLastOrNull()
                    }
                )

                // PRICELIST
                is Screen.Pricelist -> PricelistScreen(

                    onBackToMenu = {
                        backStack.clear()
                        backStack.add(Screen.Menu)
                    },

                    onDetail = { nama, harga, deskripsi, manfaat ->

                        backStack.add(
                            Screen.Detail(
                                nama = nama,
                                harga = harga,
                                deskripsi = deskripsi,
                                manfaat = manfaat
                            )
                        )
                    }
                )

                // DETAIL
                is Screen.Detail -> DetailScreen(

                    nama = current.nama,
                    harga = current.harga,
                    deskripsi = current.deskripsi,
                    manfaat = current.manfaat,

                    onBackToMenu = {
                        backStack.clear()
                        backStack.add(Screen.Menu)
                    }
                )

                // LOKASI
                is Screen.Lokasi -> LokasiScreen(

                    onBack = {
                        backStack.removeLastOrNull()
                    }
                )

                // TREATMENT
                is Screen.Treatment -> TreatmentScreen(

                    onBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        }
    }
}