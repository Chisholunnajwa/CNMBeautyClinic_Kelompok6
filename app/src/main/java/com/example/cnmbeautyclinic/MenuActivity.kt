package com.example.cnmbeautyclinic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MenuScreen(
                onKonsultasi = { startActivity(Intent(this, KonsultasiActivity::class.java)) },
                onPrice = { startActivity(Intent(this, PricelistActivity::class.java)) },
                onLokasi = { startActivity(Intent(this, LokasiActivity::class.java)) }
            )
        }
    }
}

@Composable
fun MenuScreen(
    onKonsultasi: () -> Unit,
    onPrice: () -> Unit,
    onLokasi: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF3E6))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = onKonsultasi, modifier = Modifier.fillMaxWidth()) {
            Text("Konsultasi")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = onPrice, modifier = Modifier.fillMaxWidth()) {
            Text("Price List")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = onLokasi, modifier = Modifier.fillMaxWidth()) {
            Text("Lokasi")
        }
    }
}