package com.mhmdawad.unittestingplayground

object RegistrationUtil {

    private val usedUsersName = listOf("peter", "carl")
    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmedPassword: String
    ): Boolean {
        if (username.isBlank() || username in usedUsersName)
            return false
        else if (password.length <= 2 || password.count { it.isDigit() } < 2)
            return false
        else if (password != confirmedPassword)
            return false
        return true
    }
}