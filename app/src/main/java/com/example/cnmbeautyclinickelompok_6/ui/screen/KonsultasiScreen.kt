package com.example.cnmbeautyclinickelompok_6.ui.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun KonsultasiScreen(onBack: () -> Unit) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF4EC))
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Pilih Dokter",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        val dokter = listOf(
            "dr Milla",
            "dr Fizka",
            "dr Chisholun"
        )

        dokter.forEach { namaDokter ->

            Button(
                onClick = {

                    val pesan = Uri.encode(
                        "Halo, saya ingin konsultasi dengan $namaDokter"
                    )

                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(
                            "https://wa.me/6289652457341?text=$pesan"
                        )
                    )

                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFFF6FA9)
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(namaDokter)
            }

            Spacer(modifier = Modifier.height(10.dp))
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kembali")
        }
    }
}