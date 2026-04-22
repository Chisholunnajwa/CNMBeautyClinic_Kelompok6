package com.example.cnmbeautyclinic.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MenuScreen(
    onKonsultasi: () -> Unit,
    onPrice: () -> Unit,
    onLokasi: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF4EC))
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = onKonsultasi, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0xFFFF6FA9))) {
            Text("Konsultasi")
        }

        Spacer(Modifier.height(10.dp))

        Button(onClick = onPrice, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0xFFFF6FA9))) {
            Text("Pricelist")
        }

        Spacer(Modifier.height(10.dp))

        Button(onClick = onLokasi, modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0xFFFF6FA9))) {
            Text("Lokasi")
        }
    }
}