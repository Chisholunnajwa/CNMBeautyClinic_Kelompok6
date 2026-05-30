package com.example.cnmbeautyclinickelompok_6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.cnmbeautyclinickelompok_6.data.SessionManager
import com.example.cnmbeautyclinickelompok_6.navigation.Screen
import com.example.cnmbeautyclinickelompok_6.ui.screen.DetailScreen
import com.example.cnmbeautyclinickelompok_6.ui.screen.KonsultasiScreen
import com.example.cnmbeautyclinickelompok_6.ui.screen.LokasiScreen
import com.example.cnmbeautyclinickelompok_6.ui.screen.LoginScreen
import com.example.cnmbeautyclinickelompok_6.ui.screen.MenuScreen
import com.example.cnmbeautyclinickelompok_6.ui.screen.PricelistScreen
import com.example.cnmbeautyclinickelompok_6.ui.screen.RegisterScreen
import com.example.cnmbeautyclinickelompok_6.ui.screen.TreatmentScreen
import com.example.cnmbeautyclinickelompok_6.ui.screen.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

                is Screen.Login -> {

                    LoginScreen(

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
                }

                is Screen.Register -> {

                    RegisterScreen(

                        onRegisterSuccess = {

                            backStack.clear()
                            backStack.add(Screen.Login)
                        },

                        onBackLogin = {

                            if (backStack.size > 1) {
                                backStack.removeAt(
                                    backStack.lastIndex
                                )
                            }
                        }
                    )
                }

                is Screen.Welcome -> {

                    WelcomeScreen(

                        onNext = {
                            backStack.add(Screen.Menu)
                        }
                    )
                }

                is Screen.Menu -> {

                    MenuScreen(

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
                }

                is Screen.Konsultasi -> {

                    KonsultasiScreen(

                        onBack = {

                            if (backStack.size > 1) {
                                backStack.removeAt(
                                    backStack.lastIndex
                                )
                            }
                        }
                    )
                }

                is Screen.Pricelist -> {

                    PricelistScreen(

                        onBackToMenu = {

                            backStack.clear()
                            backStack.add(Screen.Menu)
                        },

                        onDetail = {
                                nama,
                                harga,
                                deskripsi,
                                manfaat ->

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
                }

                is Screen.Detail -> {

                    DetailScreen(

                        nama = current.nama,
                        harga = current.harga,
                        deskripsi = current.deskripsi,
                        manfaat = current.manfaat,

                        onBackToMenu = {

                            backStack.clear()
                            backStack.add(Screen.Menu)
                        }
                    )
                }

                is Screen.Lokasi -> {

                    LokasiScreen(

                        onBack = {

                            if (backStack.size > 1) {
                                backStack.removeAt(
                                    backStack.lastIndex
                                )
                            }
                        }
                    )
                }

                is Screen.Treatment -> {

                    TreatmentScreen(

                        onBack = {

                            if (backStack.size > 1) {
                                backStack.removeAt(
                                    backStack.lastIndex
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}

