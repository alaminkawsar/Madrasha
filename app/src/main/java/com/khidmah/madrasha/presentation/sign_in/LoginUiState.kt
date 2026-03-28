package com.khidmah.madrasha.presentation.sign_in

import com.khidmah.madrasha.core.util.UserRole

sealed class LoginUiState {
    object Idle : LoginUiState()
    data class Success(val role: UserRole) : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}
