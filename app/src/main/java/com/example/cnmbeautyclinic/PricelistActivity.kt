package com.example.cnmbeautyclinic

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class PricelistActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PricelistScreen()
        }
    }
}

@Composable
fun PricelistScreen() {

    val context = LocalContext.current
    var selectedItem by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text("Beauty Treatments", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(10.dp))

        ItemCard("Facial Basic", "Rp 75.000") { selectedItem = "Facial Basic" }
        ItemCard("Facial Lux", "Rp 115.000") { selectedItem = "Facial Lux" }
        ItemCard("Signature Facial", "Rp 175.000") { selectedItem = "Signature Facial" }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Contouring", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(10.dp))

        ItemCard("Botox Korea 50U", "Rp 1.500.000") { selectedItem = "Botox Korea 50U" }
        ItemCard("Filler Dagu Korea", "Start From Rp 1.500.000") { selectedItem = "Filler Dagu Korea" }
    }

    if (selectedItem != null) {
        AlertDialog(
            onDismissRequest = { selectedItem = null },
            title = { Text("Silahkan Pilih") },
            text = { Text("Mau booking $selectedItem ?") },

            confirmButton = {
                Button(
                    onClick = {
                        val url = "https://wa.me/6289652457341?text=Halo saya mau booking $selectedItem"
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        context.startActivity(intent)
                        selectedItem = null
                    }
                ) {
                    Text("Booking Now")
                }
            },

            dismissButton = {
                Button(onClick = { selectedItem = null }) {
                    Text("Kembali")
                }
            }
        )
    }
}

@Composable
fun ItemCard(nama: String, harga: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF8E1E7)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(nama, fontSize = 16.sp)
            Text(harga, color = Color(0xFFFF4081))
        }
    }
}