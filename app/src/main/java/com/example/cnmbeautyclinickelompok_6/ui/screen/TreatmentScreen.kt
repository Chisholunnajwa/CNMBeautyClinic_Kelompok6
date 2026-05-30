package com.example.cnmbeautyclinickelompok_6.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.cnmbeautyclinickelompok_6.data.DBHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TreatmentScreen(
    onBack: () -> Unit
) {

    val context = LocalContext.current
    val dbHelper = DBHelper(context)

    var nama by remember { mutableStateOf("") }
    var harga by remember { mutableStateOf("") }
    var deskripsi by remember { mutableStateOf("") }
    var manfaat by remember { mutableStateOf("") }

    // untuk edit/update
    var selectedId by remember {
        mutableStateOf<Int?>(null)
    }

    var treatmentList by remember {
        mutableStateOf(dbHelper.getAll())
    }

    Scaffold(

        topBar = {

            TopAppBar(
                title = {
                    Text("Kelola Treatment")
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

            // INPUT NAMA
            OutlinedTextField(
                value = nama,
                onValueChange = {
                    nama = it
                },
                label = {
                    Text("Nama Treatment")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // INPUT HARGA
            OutlinedTextField(
                value = harga,
                onValueChange = {
                    harga = it
                },
                label = {
                    Text("Harga")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // INPUT DESKRIPSI
            OutlinedTextField(
                value = deskripsi,
                onValueChange = {
                    deskripsi = it
                },
                label = {
                    Text("Deskripsi")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // INPUT MANFAAT
            OutlinedTextField(
                value = manfaat,
                onValueChange = {
                    manfaat = it
                },
                label = {
                    Text("Manfaat")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // BUTTON TAMBAH / UPDATE
            Button(
                onClick = {

                    if (selectedId == null) {

                        // CREATE
                        dbHelper.insert(
                            nama,
                            harga,
                            deskripsi,
                            manfaat
                        )

                    } else {

                        // UPDATE
                        dbHelper.update(
                            selectedId!!,
                            nama,
                            harga,
                            deskripsi,
                            manfaat
                        )

                        selectedId = null
                    }

                    // refresh data
                    treatmentList = dbHelper.getAll()

                    // reset input
                    nama = ""
                    harga = ""
                    deskripsi = ""
                    manfaat = ""
                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    if (selectedId == null)
                        "Tambah Treatment"
                    else
                        "Update Treatment"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // LIST DATA
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {

                items(treatmentList) { item ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = item.nama,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Harga: ${item.harga}"
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = item.deskripsi
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Manfaat: ${item.manfaat}"
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            // BUTTON EDIT
                            Button(
                                onClick = {

                                    selectedId = item.id

                                    nama = item.nama
                                    harga = item.harga
                                    deskripsi = item.deskripsi
                                    manfaat = item.manfaat
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {

                                Text("Edit")
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            // BUTTON DELETE
                            Button(
                                onClick = {

                                    dbHelper.delete(item.id)

                                    treatmentList =
                                        dbHelper.getAll()
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {

                                Text("Hapus")
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // BUTTON KEMBALI
            OutlinedButton(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Kembali")
            }
        }
    }
}