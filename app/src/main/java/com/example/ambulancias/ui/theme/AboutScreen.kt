import android.os.Parcel
import android.os.Parcelable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ambulancias.R // Certifique-se de que o nome do pacote está correto

@Composable
fun AboutScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "About Us") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logotipo da Microplus
            Image(
                painter = painterResource(id = R.drawable.micropluslogo), // substitua pelo seu recurso de logotipo
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .padding(bottom = 16.dp)
            )

            Text(text = "Microplus")
            Text(text = "Inovação de Aplicações Android")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Rua de Custio 2306, 4465-606 Leça do Balio")
            Text(text = "Matosinhos, Portugal")
        }
    }
}

class AboutScreen() : Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AboutScreen> {
        override fun createFromParcel(parcel: Parcel): AboutScreen {
            return AboutScreen(parcel)
        }

        override fun newArray(size: Int): Array<AboutScreen?> {
            return arrayOfNulls(size)
        }
    }

}
