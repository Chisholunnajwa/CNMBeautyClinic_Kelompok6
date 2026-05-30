package com.example.cnmbeautyclinic.ui.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    nama: String,
    harga: String,
    deskripsi: String,
    manfaat: String,
    onBackToMenu: () -> Unit
) {

    val context = LocalContext.current

    var namaUser by remember {
        mutableStateOf("")
    }

    var showDialog by remember {
        mutableStateOf(false)
    }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text("Detail Treatment")
                }
            )
        }

    ) { padding ->

        Column(

            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()

        ) {

            Text("Nama Treatment")
            Text(nama)

            Spacer(
                Modifier.height(12.dp)
            )

            Text("Harga")
            Text(harga)

            Spacer(
                Modifier.height(12.dp)
            )

            Text("Deskripsi")
            Text(deskripsi)

            Spacer(
                Modifier.height(12.dp)
            )

            Text("Manfaat")
            Text(manfaat)

            Spacer(
                Modifier.height(20.dp)
            )

            OutlinedTextField(

                value = namaUser,

                onValueChange = {
                    namaUser = it
                },

                label = {
                    Text("Masukkan Nama")
                },

                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                Modifier.height(20.dp)
            )

            Button(

                onClick = {

                    if (namaUser.isBlank()) {
                        return@Button
                    }

                    showDialog = true
                },

                modifier = Modifier.fillMaxWidth()

            ) {
                Text("Booking Now")
            }

            Spacer(
                Modifier.height(10.dp)
            )

            OutlinedButton(

                onClick = onBackToMenu,

                modifier = Modifier.fillMaxWidth()

            ) {
                Text("Kembali")
            }
        }
    }

    if (showDialog) {

        AlertDialog(

            onDismissRequest = {
                showDialog = false
            },

            title = {
                Text("Konfirmasi Booking")
            },

            text = {
                Text("Yakin ingin booking treatment ini?")
            },

            confirmButton = {

                TextButton(

                    onClick = {

                        showDialog = false

                        val message =
                            "Halo, saya $namaUser ingin booking $nama ($harga)"

                        val uri =
                            Uri.parse(
                                "https://wa.me/6289652457341?text=$message"
                            )

                        context.startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                uri
                            )
                        )

                        onBackToMenu()
                    }

                ) {
                    Text("Ya")
                }
            },

            dismissButton = {

                TextButton(

                    onClick = {
                        showDialog = false
                    }

                ) {
                    Text("Batal")
                }
            }
        )
    }
}