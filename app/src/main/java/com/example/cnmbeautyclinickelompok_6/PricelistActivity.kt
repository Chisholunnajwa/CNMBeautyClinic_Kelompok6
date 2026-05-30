package com.example.cnmbeautyclinickelompok_6

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cnmbeautyclinickelompok_6.data.DBHelper
import com.example.cnmbeautyclinickelompok_6.model.Treatment

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

    val dbHelper = DBHelper(context)

    var treatmentList by remember {
        mutableStateOf<List<Treatment>>(emptyList())
    }

    LaunchedEffect(Unit) {

        treatmentList = dbHelper.getAll()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "PRICELIST TREATMENT",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(treatmentList) { item ->

                ItemCard(
                    nama = item.nama,
                    harga = item.harga,
                    deskripsi = item.deskripsi,
                    manfaat = item.manfaat
                )
            }
        }
    }
}

@Composable
fun ItemCard(
    nama: String,
    harga: String,
    deskripsi: String,
    manfaat: String
) {

    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {

                val intent =
                    Intent(context, DetailActivity::class.java)

                intent.putExtra("nama", nama)
                intent.putExtra("harga", harga)
                intent.putExtra("deskripsi", deskripsi)
                intent.putExtra("manfaat", manfaat)

                context.startActivity(intent)
            },

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF8E1E7)
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = nama,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = harga,
                color = Color(0xFFFF4081)
            )
        }
    }
}