package com.example.cnmbeautyclinic.ui

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

        Text("Pilih Dokter", fontSize = 22.sp)

        Spacer(Modifier.height(20.dp))

        repeat(3) {
            Button(
                onClick = {
                    val url = "https://wa.me/6289652457341"
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFFFF6FA9)),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    when (it) {
                        0 -> "dr Milla"
                        1 -> "dr Fizka"
                        else -> "dr Chisholun"
                    }
                )
            }

            Spacer(Modifier.height(10.dp))
        }

        Spacer(Modifier.height(30.dp))

        Button(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
            Text("Kembali")
        }
    }
}