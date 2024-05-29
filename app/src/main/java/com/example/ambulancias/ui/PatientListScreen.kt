package com.example.ambulancias.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.ambulancias.viewmodel.PatientViewModel

@Composable
fun PatientListScreen(navController: NavController, viewModel: PatientViewModel = viewModel()) {
    val patients by viewModel.patients.observeAsState(emptyList())

    Scaffold(
        topBar = { TopAppBar(title = { Text("Pacientes") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("patientForm") }) {
                Text("+")
            }
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier.padding(padding).padding(16.dp)
            ) {
                items(patients) { patient ->
                    Text(
                        text = patient.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate("patientForm/${patient.id}")
                            }
                            .padding(8.dp)
                    )
                }
            }
        }
    )
}
