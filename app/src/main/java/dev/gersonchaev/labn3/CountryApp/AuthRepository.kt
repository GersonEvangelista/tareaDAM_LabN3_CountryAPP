package dev.gersonchaev.labn3.CountryApp

class AuthRepository {
    private val registeredUsers = mutableListOf<User>()

    fun registerUser(user: User): Boolean {
        return if (registeredUsers.none { it.email == user.email }) {
            registeredUsers.add(user)
            true
        } else {
            false
        }
    }

    fun loginUser(email: String, password: String): Boolean {
        return registeredUsers.any { it.email == email && it.password == password }
    }
}

data class User(
    val email: String,
    val password: String
)