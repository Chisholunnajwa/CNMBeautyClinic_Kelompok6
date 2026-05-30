package com.example.cnmbeautyclinic.data

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(
            "cnm_session",
            Context.MODE_PRIVATE
        )

    fun saveLogin(
        nama: String,
        email: String
    ) {

        prefs.edit()
            .putString("nama", nama)
            .putString("email", email)
            .putBoolean("is_login", true)
            .apply()
    }

    fun getNama(): String {
        return prefs.getString("nama", "") ?: ""
    }

    fun getEmail(): String {
        return prefs.getString("email", "") ?: ""
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean("is_login", false)
    }

    fun logout() {
        prefs.edit().clear().apply()
    }
}