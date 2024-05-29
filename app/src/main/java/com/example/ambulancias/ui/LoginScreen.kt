package com.example.ambulancias.ui

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.microplus.wsGestplus.apis.GetEntityByLoginApi
import com.microplus.wsGestplus.models.Entity
import com.microplus.wsGestplus.models.LoadEntityLogin

@Composable
fun LoginScreen(navController: NavController) {
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                .padding(16.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            decorationBox = { innerTextField ->
                if (phoneNumber.isEmpty()) {
                    Text(text = "Phone Number")
                }
                innerTextField()
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                .padding(16.dp),
            visualTransformation = PasswordVisualTransformation(),
            decorationBox = { innerTextField ->
                if (password.isEmpty()) {
                    Text(text = "Password")
                }
                innerTextField()
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        val context = LocalContext.current
        Button(onClick = {
            // Function Login API
            val objws: GetEntityByLoginApi = GetEntityByLoginApi("https://core.api.gestplus.pt/")
            var lt: LoadEntityLogin = LoadEntityLogin()
            lt.strLogin = phoneNumber
            lt.strPass = password
            lt.strAppFacebookID = ""
            val re: Entity = objws.getEntityByLogin(lt)
            if (re.idCliente == null || re.idCliente == "0") {
                // Login Failed
                Toast.makeText(context, "Login Inválido!", Toast.LENGTH_SHORT).show()
            } else {
                // Login Successful
                navController.navigate("menuscreen")
            }
        }) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Não tem uma conta? Crie agora",
            color = Color.Blue,
            modifier = Modifier.clickable {
                navController.navigate("register_screen")
            }
        )
    }
}
