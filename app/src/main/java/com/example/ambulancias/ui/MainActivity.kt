package com.example.ambulancias.ui

import android.os.Bundle
import android.os.StrictMode
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import com.example.ambulancias.navigation.addMainGraph
import com.microplus.wsGestplus.infrastructure.ApiClient

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmbulanciasApp()
        }
    }
}

@Composable
fun AmbulanciasApp() {
    val navController = rememberNavController()
    val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
    StrictMode.setThreadPolicy(policy)

    val jwt = "your_jwt_token_here"
    ApiClient.defaultHeaders += mapOf("Authorization" to "Bearer $jwt")

    MainNavHost(navController)
}

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login_screen"
    ) {
        addMainGraph(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AmbulanciasApp()
}
