package com.example.ambulancias.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ambulancias.model.Patient
import com.example.ambulancias.network.RetrofitInstance
import kotlinx.coroutines.launch

class PatientViewModel : ViewModel() {
    private val _patients = MutableLiveData<List<Patient>>()
    val patients: LiveData<List<Patient>> = _patients

    init {
        fetchPatients()
    }

    private fun fetchPatients() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPatients()
                if (response.isSuccessful && response.body() != null) {
                    _patients.value = response.body()
                }
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

