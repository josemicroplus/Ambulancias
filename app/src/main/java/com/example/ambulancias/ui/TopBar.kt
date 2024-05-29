package com.example.ambulancias.ui

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.navigation.NavController

@Composable
fun TopBar(
    navController: NavController,
    isRootScreen: Boolean,
    onMenuClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "App Title") },
        navigationIcon = {
            if (!isRootScreen) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null)
                }
            } else {
                IconButton(onClick = onMenuClick) {
                    Icon(Icons.Filled.Menu, contentDescription = null)
                }
            }
        }
    )
}
