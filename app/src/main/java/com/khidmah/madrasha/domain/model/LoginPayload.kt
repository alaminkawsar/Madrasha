package com.khidmah.madrasha.domain.model

data class LoginPayload(
    val emailPhone: String,
    val password: String
)
