package com.example.cnmbeautyclinickelompok_6.data

import javax.inject.Inject

class TreatmentRepository @Inject constructor() {

    fun getCategories(): List<Category> {
        return treatmentCategories
    }
}

