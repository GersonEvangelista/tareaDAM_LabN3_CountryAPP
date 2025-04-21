package dev.gersonchaev.labn3.CountryApp

sealed class AppScreens(val route: String) {
    object Login : AppScreens("login")
    object Register : AppScreens("register")
    object Home : AppScreens("home")
}