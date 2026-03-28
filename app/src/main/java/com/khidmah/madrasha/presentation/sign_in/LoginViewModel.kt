package com.khidmah.madrasha.presentation.sign_in

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.khidmah.madrasha.core.util.UserRole
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    // Inject repository if you have, else leave empty for now
) : ViewModel() {

    private val TAG = "LoginViewModel"

    var username by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var selectedRole by mutableStateOf(UserRole.ADMIN)
        private set

    var loginState by mutableStateOf<LoginUiState>(LoginUiState.Idle)
        private set

    // Update fields
    fun onUsernameChange(newValue: String) {
        Log.d(TAG, "onUsernameChange: $newValue")
        username = newValue
    }

    fun onPasswordChange(newValue: String) {
        Log.d(TAG, "onPasswordChange: $newValue")
        password = newValue
    }

    fun onRoleSelected(role: UserRole) {
        Log.d(TAG, "onRoleSelected: $role")
        selectedRole = role
    }

    // Trigger login (simple validation for now)
    fun login() {
        Log.d(TAG, "login: $username, $password, $selectedRole")
        // TODO: Add below check for username and password
//        if (username.isBlank() || password.isBlank()) {
//            loginState = LoginUiState.Error("Username or password cannot be empty")
//            return
//        }
        // Simulate success for now
        loginState = LoginUiState.Success(selectedRole)
    }

    fun resetState() {
        loginState = LoginUiState.Idle
    }
}

