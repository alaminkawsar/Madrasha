package com.example.madrasha.presentation.sign_in

import android.app.Application
import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.madrasha.core.UIEvent
import com.example.madrasha.domain.model.LoginPayload
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val preferences: SharedPreferences,
    private val application: Application
) : ViewModel() {
    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _isValidEmail = mutableStateOf(true)
    val isValidEmail: State<Boolean> = _isValidEmail

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _isInvalidPassword = mutableStateOf(true)
    val isInvalidPassword: State<Boolean> = _isInvalidPassword

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _showCircularProgress = mutableStateOf(false)

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _showInvalidCredentialErrorMessage = mutableStateOf(false)
    val showInvalidCredentialErrorMessage: State<Boolean> = _showInvalidCredentialErrorMessage

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

//    private val getLoginData = GetLoggedInUser()
    fun onEvent(event: SignInEvent) {
        _showInvalidCredentialErrorMessage.value = false
        when (event) {
            is SignInEvent.EnteredEmail -> {
                _email.value = event.email
                _isValidEmail.value = true
            }

            is SignInEvent.EnteredPassword -> {
                _password.value = event.password
                _isInvalidPassword.value = true
            }

            is SignInEvent.ShowPassword -> {
                _showPassword.value = !showPassword.value
            }

            is SignInEvent.ShowCircularProgress -> {
                _showCircularProgress.value = !_showCircularProgress.value
            }

            is SignInEvent.SignInButtonClick -> {

                // debugging purposes
                val loginData = LoginPayload(
                    emailPhone = "a@k.com",
                    password = "abCD12!@"
                )
                checkCredential(event, loginData)

//                if (checkInputValidation()) {
//                    val loginData = LoginPayload(_email.value, _password.value)
//                    checkCredential(event, loginData)
//                }
            }
        }
    }

    private fun checkCredential(event: SignInEvent.SignInButtonClick, loginPayload: LoginPayload) { // need to change letter
        viewModelScope.launch @androidx.annotation.RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE) {
//            val isInternetAvailable =
//                CheckInternetConnection.checkInternetConnection(application.applicationContext)
//            if (!isInternetAvailable) {
//                delay(1)
//                _eventFlow.emit(UIEvent.ShowSnackBar("Please check your internet connection and try again"))
//                return@launch
//            }
//            TokenManager.getCsrfToken(preferences = preferences) { csrfToken ->
//                getLoginData(
//                    loginPayload = loginPayload,
//                    csrfToken = csrfToken
//                ).onEach { resource ->
//                    when (resource) {
//                        is Resource.Loading -> {
//                            _isLoading.value = true
//                        }
//
//                        is Resource.Error -> {
//                            _isLoading.value = false
//                            _eventFlow.emit(
//                                UIEvent.ShowToastMessage(
//                                    resource.message ?: "Unknown error occurred"
//                                )
//                            )
//                        }
//
//                        is Resource.Success -> {
//                            _isLoading.value = false
//                            val loginResponse = resource.data
//                            loginResponse?.let {
//                                TokenManager.saveJWTToken(preferences, it.token)
//                                Utilities.saveAuthorId(preferences, it.user.userId)
//                                // Log.d("SignInViewModel", it.toString())
//                            }
//                            event.onSuccess()
//                        }
//                    }
//                }.launchIn(this)
//            }
        }
    }

    private fun checkInputValidation(): Boolean {
        // check email validation
        _isValidEmail.value = emailNumberValidation(_email.value)
        // password
        val passwordRegex =
            Regex("^(?=(.*\\d.*){2})(?=(.*[A-Z].*){2})(?=(.*[a-z].*){2})(?=(.*[!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*){2})[A-Za-z\\d!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]{8,}\$")
        _isInvalidPassword.value = passwordRegex.matches(_password.value)

        return _isValidEmail.value
    }

    private fun emailNumberValidation(input: String): Boolean {
        val regexNumber = Regex("^\\+?\\d{11,}$")
        val regexEmail = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
        return regexNumber.matches(input) or regexEmail.matches(input)
    }
}