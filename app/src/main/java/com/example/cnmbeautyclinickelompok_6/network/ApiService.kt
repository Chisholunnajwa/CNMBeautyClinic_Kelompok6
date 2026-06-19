package com.example.cnmbeautyclinickelompok_6.network

import com.example.cnmbeautyclinickelompok_6.model.Treatment
import retrofit2.http.GET

interface ApiService {

    @GET(value = "get_treatments.php")
    suspend fun getTreatments(): List<Treatment>

}