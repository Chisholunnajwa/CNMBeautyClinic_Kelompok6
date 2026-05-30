package com.example.cnmbeautyclinickelompok_6.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cnmbeautyclinickelompok_6.data.Category
import com.example.cnmbeautyclinickelompok_6.data.TreatmentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TreatmentViewModel @Inject constructor(
    private val repository: TreatmentRepository
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

