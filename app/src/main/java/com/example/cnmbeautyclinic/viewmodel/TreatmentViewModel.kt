package com.example.cnmbeautyclinic.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cnmbeautyclinic.data.Category
import com.example.cnmbeautyclinic.data.TreatmentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TreatmentViewModel(
    private val repository: TreatmentRepository = TreatmentRepository()
) : ViewModel() {

    private val _categories =
        MutableStateFlow<List<Category>>(emptyList())

    val categories: StateFlow<List<Category>> =
        _categories

    init {
        loadTreatments()
    }

    private fun loadTreatments() {

        viewModelScope.launch {

            _categories.value =
                repository.getCategories()
        }
    }
}