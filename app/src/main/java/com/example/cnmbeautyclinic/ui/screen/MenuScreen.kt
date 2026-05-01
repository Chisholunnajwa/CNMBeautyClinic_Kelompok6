package com.example.cnmbeautyclinic.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    onKonsultasi: () -> Unit,
    onPrice: () -> Unit,
    onLokasi: () -> Unit,
    onLogout: () -> Unit,
    onTreatment: () -> Unit
) {

    val context = LocalContext.current

    var showSheet by remember { mutableStateOf(false) }

    val sheetState = rememberModalBottomSheetState()

    val scope = rememberCoroutineScope()

    Scaffold(

        containerColor = Color(0xFFFFF4EC),

        topBar = {

            TopAppBar(

                title = {

                    Text("CNM Beauty Clinic")
                }
            )
        }

    ) { padding ->

        Column(

            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
                .fillMaxSize(),

            verticalArrangement = Arrangement.Center

        ) {

            // BUTTON KONSULTASI
            Button(

                onClick = onKonsultasi,

                modifier = Modifier.fillMaxWidth(),

                colors = ButtonDefaults.buttonColors(
                    Color(0xFFFF6FA9)
                )

            ) {

                Text("Konsultasi")
            }

            Spacer(modifier = Modifier.height(10.dp))

            // BUTTON PRICELIST
            Button(

                onClick = onPrice,

                modifier = Modifier.fillMaxWidth(),

                colors = ButtonDefaults.buttonColors(
                    Color(0xFFFF6FA9)
                )

            ) {

                Text("Pricelist")
            }

            Spacer(modifier = Modifier.height(10.dp))

            // BUTTON LOKASI
            Button(

                onClick = onLokasi,

                modifier = Modifier.fillMaxWidth(),

                colors = ButtonDefaults.buttonColors(
                    Color(0xFFFF6FA9)
                )

            ) {

                Text("Lokasi")
            }

            Spacer(modifier = Modifier.height(10.dp))

            // BUTTON CRUD
            Button(

                onClick = onTreatment,

                modifier = Modifier.fillMaxWidth(),

                colors = ButtonDefaults.buttonColors(
                    Color(0xFFFF6FA9)
                )

            ) {

                Text("Kelola Treatment")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // BUTTON BOTTOM SHEET
            OutlinedButton(

                onClick = {

                    showSheet = true
                },

                modifier = Modifier.fillMaxWidth()

            ) {

                Text("Lihat Menu (Bottom Sheet)")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // BUTTON LOGOUT
            Button(

                onClick = onLogout,

                modifier = Modifier.fillMaxWidth(),

                colors = ButtonDefaults.buttonColors(
                    Color.Red
                )

            ) {

                Text("Logout")
            }
        }
    }

    // MODAL BOTTOM SHEET
    if (showSheet) {

        ModalBottomSheet(

            onDismissRequest = {

                scope.launch {

                    sheetState.hide()

                }.invokeOnCompletion {

                    showSheet = false
                }
            },

            sheetState = sheetState

        ) {

            LazyColumn {

                // TENTANG KLINIK
                item {

                    ListItem(

                        headlineContent = {

                            Text("Tentang Klinik")
                        },

                        supportingContent = {

                            Text(
                                "CNM Beauty Clinic menyediakan berbagai treatment kecantikan modern."
                            )
                        }
                    )
                }

                // BANTUAN
                item {

                    ListItem(

                        headlineContent = {

                            Text("Bantuan")
                        },

                        supportingContent = {

                            Text(

                                text = "Hubungi admin: 089652457341",

                                modifier = Modifier.clickable {

                                    val intent = Intent(

                                        Intent.ACTION_VIEW,

                                        Uri.parse(
                                            "https://wa.me/6289652457341"
                                        )
                                    )

                                    context.startActivity(intent)
                                }
                            )
                        }
                    )
                }

                // LOGOUT
                item {

                    ListItem(

                        headlineContent = {

                            Text("Logout")
                        },

                        modifier = Modifier.clickable {

                            onLogout()
                        }
                    )
                }
            }

            // BUTTON TUTUP
            OutlinedButton(

                onClick = {

                    scope.launch {

                        sheetState.hide()

                    }.invokeOnCompletion {

                        showSheet = false
                    }
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)

            ) {

                Text("Tutup")
            }
        }
    }
}