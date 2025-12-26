package com.example.madrasha.presentation.sign_in

sealed class SignInEvent {
    data class EnteredEmail(val email: String) : SignInEvent()
    data class EnteredPassword(val password: String) : SignInEvent()
    object ShowPassword : SignInEvent()
    object ShowCircularProgress : SignInEvent()
    class SignInButtonClick(val onSuccess: () -> Unit) : SignInEvent()
}