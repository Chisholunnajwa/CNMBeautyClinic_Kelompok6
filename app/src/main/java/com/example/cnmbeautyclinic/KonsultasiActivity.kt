package com.example.cnmbeautyclinic

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

class KonsultasiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KonsultasiScreen { finish() }
        }
    }
}

@Composable
fun KonsultasiScreen(onBack: () -> Unit) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text("Pilih Dokter", fontSize = 22.sp)

        Spacer(modifier = Modifier.height(20.dp))

        fun openWA(text: String) {
            val message = Uri.encode(text)
            val url = "https://wa.me/6289652457341?text=$message"
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        Button(onClick = { openWA("Halo saya ingin konsultasi dengan Dr Milla") }, modifier = Modifier.fillMaxWidth()) {
            Text("dr.Milla")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { openWA("Halo saya ingin konsultasi dengan Dr Fizka") }, modifier = Modifier.fillMaxWidth()) {
            Text("dr.Fizka")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = { openWA("Halo saya ingin konsultasi") }, modifier = Modifier.fillMaxWidth()) {
            Text("dr.Chisholun")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
            Text("Kembali")
        }
    }
}