package dev.gersonchaev.labn3.CountryApp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.gersonchaev.labn3.AuthViewModelFactory

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory(AuthRepository()))

    NavHost(
        navController = navController,
        startDestination = AppScreens.Register.route
    ) {
        composable(AppScreens.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(AppScreens.Home.route) {
                        popUpTo(AppScreens.Login.route) { inclusive = true } // Clear backstack
                    }
                },
                onNavigateToRegister = { navController.navigate(AppScreens.Register.route) },
                viewModel = viewModel
            )
        }

        composable(AppScreens.Register.route) {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(AppScreens.Login.route) {
                        popUpTo(AppScreens.Register.route) { inclusive = true } // Clear backstack
                    }
                },
                onNavigateToLogin = { navController.navigate(AppScreens.Login.route) }, // Navigate back
                viewModel = viewModel
            )
        }

        composable(AppScreens.Home.route) {
            HomeScreen(
                onLogout = {
                    navController.navigate(AppScreens.Login.route) {
                        popUpTo(AppScreens.Home.route) { inclusive = true } // Clear backstack
                    }
                }
            )
        }
    }
}