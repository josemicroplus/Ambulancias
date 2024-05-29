package com.example.ambulancias.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ambulancias.viewmodel.PatientViewModel
import com.example.ambulancias.model.Patient
import java.util.*

@Composable
fun PatientFormScreen(navController: NavController, patientId: String?, viewModel: PatientViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var postalCode by remember { mutableStateOf("") }
    var district by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var healthStatus by remember { mutableStateOf("") }
    var specialCare by remember { mutableStateOf(false) }

    val isEdit = patientId != null
    val currentPatient = viewModel.patients.value?.find { it.id == patientId }

    LaunchedEffect(currentPatient) {
        currentPatient?.let {
            name = it.name
            address = it.address
            city = it.city
            postalCode = it.postalCode
            district = it.district
            country = it.country
            healthStatus = it.healthStatus
            specialCare = it.specialCare
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (isEdit) "Editar Paciente" else "Adicionar Paciente") }
            )
        },
        content = { padding ->
            Column(modifier = Modifier
                .padding(padding)
                .padding(16.dp)) {
                TextField(value = name, onValueChange = { name = it }, label = { Text("Nome") })
                Spacer(modifier = Modifier.height(8.dp))
                TextField(value = address, onValueChange = { address = it }, label = { Text("Morada") })
                Spacer(modifier = Modifier.height(8.dp))
                TextField(value = city, onValueChange = { city = it }, label = { Text("Localidade") })
                Spacer(modifier = Modifier.height(8.dp))
                TextField(value = postalCode, onValueChange = { postalCode = it }, label = { Text("Código Postal") })
                Spacer(modifier = Modifier.height(8.dp))
                TextField(value = district, onValueChange = { district = it }, label = { Text("Distrito") })
                Spacer(modifier = Modifier.height(8.dp))
                TextField(value = country, onValueChange = { country = it }, label = { Text("País") })
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = healthStatus,
                    onValueChange = { healthStatus = it },
                    label = { Text("Estado de Saúde") },
                    modifier = Modifier.height(100.dp),
                    maxLines = 4,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = specialCare, onCheckedChange = { specialCare = it })
                    Text("Precisa de cuidados especiais")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { /* Lógica para adicionar foto */ }) {
                    Text("Adicionar Foto")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    val patient = Patient(
                        id = patientId ?: UUID.randomUUID().toString(),
                        name = name,
                        address = address,
                        city = city,
                        postalCode = postalCode,
                        district = district,
                        country = country,
                        healthStatus = healthStatus,
                        specialCare = specialCare
                    )
                    if (isEdit) {
                        viewModel.updatePatient(patient)
                    } else {
                        viewModel.addPatient(patient)
                    }
                    navController.popBackStack()
                }) {
                    Text("Salvar")
                }
            }
        }
    )
}
