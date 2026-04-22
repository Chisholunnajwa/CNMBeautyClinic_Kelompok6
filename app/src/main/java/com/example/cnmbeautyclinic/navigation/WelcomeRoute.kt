package com.example.cnmbeautyclinic.navigation

import androidx.compose.runtime.Composable
import com.example.cnmbeautyclinic.ui.WelcomeScreen

@Composable
fun WelcomeRoute() {
    val backStack = LocalBackStack.current

    WelcomeScreen {
        backStack.add(Screen.Menu)
    }
}