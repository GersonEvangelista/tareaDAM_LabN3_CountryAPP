package dev.gersonchaev.labn3.CountryApp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {
    sealed class AuthState {
        object Idle : AuthState()
        object Loading : AuthState()
        data class Success(val message: String) : AuthState()
        data class Error(val message: String) : AuthState()
    }

    private val _registerState = mutableStateOf<AuthState>(AuthState.Idle)
    val registerState: State<AuthState> = _registerState

    private val _loginState = mutableStateOf<AuthState>(AuthState.Idle)
    val loginState: State<AuthState> = _loginState

    fun register(email: String, password: String) {
        _registerState.value = AuthState.Loading
        viewModelScope.launch {
            try {
                val success = repository.registerUser(User(email, password))
                _registerState.value = if (success) AuthState.Success("Registro exitoso") else AuthState.Error("Correo ya registrado")
            } catch (e: Exception) {
                _registerState.value = AuthState.Error("Error al registrar")
            }
        }
    }

    fun login(email: String, password: String) {
        _loginState.value = AuthState.Loading
        viewModelScope.launch {
            try {
                val success = repository.loginUser(email, password)
                _loginState.value = if (success) AuthState.Success("Inicio de sesión exitoso") else AuthState.Error("Credenciales inválidas")
            } catch (e: Exception) {
                _loginState.value = AuthState.Error("Error al iniciar sesión")
            }
        }
    }
}