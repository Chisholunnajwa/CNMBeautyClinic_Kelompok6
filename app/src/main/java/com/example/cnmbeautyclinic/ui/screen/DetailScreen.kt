package com.example.cnmbeautyclinic.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun DetailScreen(
    nama: String,
    harga: String,
    onBackToMenu: () -> Unit
) {

    val context = LocalContext.current

    // STATE INPUT
    var namaUser by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }

    Column(Modifier.padding(20.dp)) {

        Text("Detail Treatment")
        Text("Treatment: $nama")
        Text("Harga: $harga")

        Spacer(Modifier.height(20.dp))

        // INPUT NAMA
        OutlinedTextField(
            value = namaUser,
            onValueChange = { namaUser = it },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(10.dp))

        // INPUT NO HP
        OutlinedTextField(
            value = noHp,
            onValueChange = { noHp = it },
            label = { Text("No HP") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(20.dp))

        // BUTTON BOOKING
        Button(
            onClick = {

                val message = """
                    Halo, saya ingin booking treatment
                    
                    Nama: $namaUser
                    No HP: $noHp
                    Treatment: $nama
                    Harga: $harga
                """.trimIndent()

                val encodedMessage = URLEncoder.encode(
                    message,
                    StandardCharsets.UTF_8.toString()
                )

                val url = "https://wa.me/6289652457341?text=$encodedMessage"

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)

                // BALIK KE MENU
                onBackToMenu()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Booking Now")
        }

        Spacer(Modifier.height(10.dp))

        Button(onClick = onBackToMenu) {
            Text("Kembali")
        }
    }
}