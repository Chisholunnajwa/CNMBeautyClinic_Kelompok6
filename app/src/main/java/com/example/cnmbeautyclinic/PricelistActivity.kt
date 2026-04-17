package com.example.cnmbeautyclinic

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text("BEAUTY TREATMENTS", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(10.dp))

        ItemCard("Facial Basic", "Rp 75.000")
        ItemCard("Facial Lux", "Rp 115.000")
        ItemCard("Signature Facial", "Rp 175.000")
        ItemCard("Facial Oxygeneo Neocell", "Rp 375.000")
        ItemCard("Light Chemical Peeling", "Rp 195.000")
        ItemCard("Advance Chemical Peeling", "Rp 250.000")
        ItemCard("Premium Chemical Peeling", "Rp 450.000")
        ItemCard("Mesotherapy No Needle (Whitening, Open Pore, Anti Aging)", "Rp 175.000")
        ItemCard("Acne Clear Booster", "Rp 550.000")
        ItemCard("Flek Injection", "Rp 550.000")
        ItemCard("Colagen Stimulator", "Start From Rp 1.500.000")
        ItemCard("Skin Booster", "Start From Rp 750.000")
        ItemCard("Fat Free Injection", "Rp 200.000/cc")
        ItemCard("RF-Cavitasi", "Start From Rp 75.000")
        ItemCard("HIFU", "Start From Rp 250.000")
        ItemCard("Dermalux IPL", "Start From Rp 250.000")
        ItemCard("Laser Ndyag", "Start From Rp 250.000")
        ItemCard("Laser Rebeam", "Start From Rp 250.000")
        ItemCard("Laser Fractional Co2", "Rp 1.500.000")
        ItemCard("Electrocauter", "Start From Rp 200.000")
        ItemCard("Fat Freezing & Lipo Laser", "Start From Rp 550.000")
        ItemCard("PRP", "Rp 450.000")
        ItemCard("Dermaglow", "Rp 650.000")
        ItemCard("Injeksi Acne", "Start From Rp 35.000")
        ItemCard("Injeksi VIT C", "Rp 125.000")

        Spacer(modifier = Modifier.height(10.dp))

        Text("INFUS", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(10.dp))

        ItemCard("Skin Refresher", "Rp 550.000")
        ItemCard("Bright Skin", "Rp 750.000")
        ItemCard("Diamond Whitening", "Rp 950.000")
        ItemCard("PDT + Mask", "Rp 50.000")

        Spacer(modifier = Modifier.height(10.dp))

        Text("CONTOURING", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(10.dp))

        ItemCard("Botox Korea 50U", "Rp 1.500.000")
        ItemCard("Botox Lanzox 50U", "Rp 2.999.000")
        ItemCard("Filler Dagu Korea", "Start From Rp 1.500.000")
        ItemCard("Korea Nose Threadlift", "Rp 550.000/benang")
        ItemCard("Face Lift", "Rp 950.000/benang")
    }
}

@Composable
fun ItemCard(nama: String, harga: String) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("nama", nama)
                intent.putExtra("harga", harga)
                context.startActivity(intent)
            },
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