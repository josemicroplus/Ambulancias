package com.example.ambulancias.navigation

import MenuScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.ambulancias.ui.LoginScreen



fun NavGraphBuilder.addMainGraph(navController: NavHostController) {
    composable("login_screen") {
        LoginScreen(navController)
    }
    composable("register_screen") {
        /* RegisterScreen(navController) */
    }
    composable("menuscreen") {
        MenuScreen(navController)

    }
}

   // composable("paciente_registo") {
    //    PacienteRegisto(navController)
    //    }
//}
