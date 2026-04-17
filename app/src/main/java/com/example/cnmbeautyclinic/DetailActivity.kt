package com.example.cnmbeautyclinic

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nama = intent.getStringExtra("nama") ?: ""
        val harga = intent.getStringExtra("harga") ?: ""

        setContent {
            DetailScreen(nama, harga)
        }
    }
}

@Composable
fun DetailScreen(nama: String, harga: String) {
    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Detail Treatment", fontSize = 22.sp)

        Spacer(modifier = Modifier.height(10.dp))

        Text("Nama: $nama")
        Text("Harga: $harga")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val message = Uri.encode("Halo saya mau booking $nama")
                val url = "https://wa.me/6289652457341?text=$message"
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Booking Now")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { (context as Activity).finish() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kembali")
        }
    }
}