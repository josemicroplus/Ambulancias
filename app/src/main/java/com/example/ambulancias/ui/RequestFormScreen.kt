package com.example.ambulancias.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RequestFormScreen(navController: NavController) {
    var originAddress by remember { mutableStateOf("") }
    var destinationAddress by remember { mutableStateOf("") }
    var originCoordinates by remember { mutableStateOf("") }
    var destinationCoordinates by remember { mutableStateOf("") }

    // Função fictícia para obter coordenadas a partir da morada
    fun getCoordinates(address: String): String {
        return "Lat: XX.XXXX, Lon: XX.XXXX" // Implementar lógica real de geocodificação
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Novo Pedido de Ambulância") }) },
        content = { padding ->
            Column(modifier = Modifier.padding(padding).padding(16.dp)) {
                TextField(value = originAddress, onValueChange = { originAddress = it }, label = { Text("Morada de Origem") })
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    originCoordinates = getCoordinates(originAddress)
                }) {
                    Text("Obter Coordenadas de Origem")
                }
                Text(text = originCoordinates, modifier = Modifier.padding(8.dp))

                Spacer(modifier = Modifier.height(8.dp))
                TextField(value = destinationAddress, onValueChange = { destinationAddress = it }, label = { Text("Morada de Destino") })
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    destinationCoordinates = getCoordinates(destinationAddress)
                }) {
                    Text("Obter Coordenadas de Destino")
                }
                Text(text = destinationCoordinates, modifier = Modifier.padding(8.dp))

                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    // Lógica para salvar pedido
                    navController.popBackStack()
                }) {
                    Text("Salvar")
                }
            }
        }
    )
}
