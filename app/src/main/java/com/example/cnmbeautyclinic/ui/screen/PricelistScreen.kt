package com.example.cnmbeautyclinic.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cnmbeautyclinic.data.Category
import com.example.cnmbeautyclinic.viewmodel.TreatmentViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PricelistScreen(
    onBackToMenu: () -> Unit,
    onDetail: (String, String, String, String) -> Unit,
    viewModel: TreatmentViewModel = viewModel()
) {

    val categories by viewModel.categories.collectAsState()

    PricelistContent(
        categories = categories,
        onBackToMenu = onBackToMenu,
        onDetail = onDetail
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PricelistContent(
    categories: List<Category>,
    onBackToMenu: () -> Unit,
    onDetail: (
        String,
        String,
        String,
        String
    ) -> Unit
) {

    Scaffold(
        containerColor = Color(0xFFFFF4EC),

        topBar = {
            TopAppBar(
                title = {
                    Text("PRICE LIST")
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {

                categories.forEach { category ->

                    item {

                        Text(
                            text = category.title,
                            modifier = Modifier.padding(16.dp),
                            color = Color(0xFFE91E63)
                        )
                    }

                    items(category.items) { item ->

                        ItemCard(
                            nama = item.nama,
                            harga = item.harga,
                            deskripsi = item.deskripsi,
                            manfaat = item.manfaat
                        ) {

                            onDetail(
                                item.nama,
                                item.harga,
                                item.deskripsi,
                                item.manfaat
                            )
                        }
                    }
                }

                item {
                    Spacer(
                        modifier = Modifier.height(80.dp)
                    )
                }
            }

            Button(
                onClick = onBackToMenu,

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                colors = ButtonDefaults.buttonColors(
                    Color(0xFFFF6FA9)
                )
            ) {
                Text("Kembali ke Menu")
            }
        }
    }
}

@Composable
fun ItemCard(
    nama: String,
    harga: String,
    deskripsi: String,
    manfaat: String,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 6.dp
            )
            .clickable { onClick() },

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFD6E7)
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(nama)

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Text(
                harga,
                color = Color(0xFFE91E63)
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text("Deskripsi")

            Text(deskripsi)

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text("Manfaat")

            Text(manfaat)
        }
    }
}