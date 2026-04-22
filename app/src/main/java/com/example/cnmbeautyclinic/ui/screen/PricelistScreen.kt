package com.example.cnmbeautyclinic.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cnmbeautyclinic.data.treatmentCategories

@Composable
fun PricelistScreen(
    onBackToMenu: () -> Unit,
    onDetail: (String, String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF4EC)) // cream background
    ) {

        // 🔥 JUDUL
        Text(
            text = "PRICE LIST",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )

        // 🔥 LIST
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            treatmentCategories.forEach { category ->

                // 🔥 TITLE KATEGORI
                item {
                    Text(
                        text = category.title,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
                    )
                }

                // 🔥 ITEM LIST
                items(category.items) { item ->
                    RowItem(
                        nama = item.nama,
                        harga = item.harga
                    ) {
                        onDetail(item.nama, item.harga)
                    }
                }
            }
        }

        // 🔙 BUTTON BACK
        Button(
            onClick = onBackToMenu,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFFF6FA9))
        ) {
            Text("Kembali ke Menu")
        }
    }
}

@Composable
fun RowItem(
    nama: String,
    harga: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = nama,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = harga,
            color = Color(0xFFE91E63)
        )
    }
}