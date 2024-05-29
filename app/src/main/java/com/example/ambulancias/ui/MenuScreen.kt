import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import com.example.ambulancias.R
import com.example.ambulancias.ui.TopBar



@Composable
fun MenuScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(
                navController = navController,
                isRootScreen = true,
                onMenuClick = { /* Handle menu click */ }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.t4s),
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .padding(bottom = 32.dp)
            )

            Text(text = "Menu")

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                navController.navigate("register_screen")
            }) {
                Text(text = "Go to Register Screen")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                navController.navigate("login_screen")
            }) {
                Text(text = "Go to Login Screen")
            }
        }
    }
}
