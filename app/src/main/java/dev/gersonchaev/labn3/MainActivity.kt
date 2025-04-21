package dev.gersonchaev.labn3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.gersonchaev.labn3.CountryApp.AppNavigation
import dev.gersonchaev.labn3.CountryApp.AuthRepository
import dev.gersonchaev.labn3.CountryApp.AuthViewModel
import dev.gersonchaev.labn3.CountryApp.HomeScreen
import dev.gersonchaev.labn3.ui.theme.LabN3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: AuthViewModel by viewModels { AuthViewModelFactory(AuthRepository()) }

        enableEdgeToEdge()
        setContent {
            LabN3Theme {
                 AppNavigation()
            }
        }
    }

    private fun navigateToHome() {
        // Aquí iría la navegación a la pantalla principal de la app
        Toast.makeText(this, "Autenticación exitosa!", Toast.LENGTH_SHORT).show()
    }

}

// Factory para el ViewModel
class AuthViewModelFactory(private val authRepository: AuthRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AuthViewModel(authRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabN3Theme {
        Greeting("Android")
    }
}