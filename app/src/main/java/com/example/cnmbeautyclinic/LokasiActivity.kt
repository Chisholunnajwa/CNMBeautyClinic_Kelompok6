package com.example.cnmbeautyclinic

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LokasiActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LokasiScreen(
                onBack = { finish() },
                onExit = { finishAffinity() }
            )
        }
    }
}

@Composable
fun LokasiScreen(
    onBack: () -> Unit,
    onExit: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "CNM Aesthetic Center",
            fontSize = 22.sp
        )

        Text(
            text = "Kebumen Kota",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                val gmmIntentUri =
                    Uri.parse("geo:0,0?q=CNM+Aesthetic+Center+Kebumen")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

                if (mapIntent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(mapIntent)
                } else {
                    val uri = Uri.parse(
                        "https://www.google.com/maps/search/?api=1&query=CNM+Aesthetic+Center+Kebumen"
                    )
                    val browserIntent = Intent(Intent.ACTION_VIEW, uri)
                    context.startActivity(browserIntent)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF6FA9)
            ),
            shape = RoundedCornerShape(50)
        ) {
            Text("Buka Google Maps")
        }

        Spacer(modifier = Modifier.height(12.dp))

        // BUTTON KEMBALI
        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Kembali")
        }

        Spacer(modifier = Modifier.height(12.dp))

        // BUTTON KELUAR
        Button(
            onClick = onExit,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Keluar Aplikasi")
        }
    }
}