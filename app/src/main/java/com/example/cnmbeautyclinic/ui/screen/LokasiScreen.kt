package com.example.cnmbeautyclinic.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun LokasiScreen(onBack: () -> Unit) {

    val context = LocalContext.current

    Column(Modifier.padding(20.dp)) {

        Text("CNM Aesthetic Center")
        Text("Kebumen Kota")

        Spacer(Modifier.height(20.dp))

        Button(onClick = {
            val uri = Uri.parse("https://www.google.com/maps/search/?api=1&query=CNM+Aesthetic+Center+Kebumen")
            context.startActivity(Intent(Intent.ACTION_VIEW, uri))
        }) {
            Text("Buka Maps")
        }

        Spacer(Modifier.height(10.dp))

        Button(onClick = onBack) {
            Text("Kembali")
        }
    }
}