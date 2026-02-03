//package com.example.madrasha.core.util
//
//import android.content.SharedPreferences
//
//object TokenManager {
//
//    private const val KEY_CSRF_TOKEN = "csrf_token"
//    private const val KEY_JWT_TOKEN = "jwt_token"
//    private const val KEY_CSRF_EXPIRATION_TIME = "csrf_expiration_time"
//    private const val KEY_JWT_EXPIRATION_TIME = "jwt_expiration_time"
//    private const val EXPIRATION_TIME = 3600000
//
//    // Save the CSRF token and its expiration time
//    private fun saveCsrfToken(preferences: SharedPreferences, token: String) {
//        val currentTime = System.currentTimeMillis()
//
//        clearToken(KEY_CSRF_TOKEN, KEY_CSRF_EXPIRATION_TIME, preferences)
//        preferences.edit().putString(KEY_CSRF_TOKEN, token).apply()
//        preferences.edit().putLong(KEY_CSRF_EXPIRATION_TIME, currentTime).apply()
//    }
//
//    // Retrieve the CSRF token
//    suspend fun getCsrfToken(preferences: SharedPreferences, onCsrfTokenFetched: suspend (String) -> Unit){
//        var csrfToken = preferences.getString(KEY_CSRF_TOKEN, "")?: ""
//        if (!isTokenValid(KEY_CSRF_EXPIRATION_TIME, preferences)) {
//            val calCsrfToken = GetCsrfToken()
//            calCsrfToken().collect {
//                csrfToken = it?.csrfToken?:""
//                saveCsrfToken(preferences, csrfToken)
//                onCsrfTokenFetched(csrfToken)
//            }
//        } else onCsrfTokenFetched(csrfToken)
//    }
//
//    // Check if the CSRF token is still valid (expiration time hasn't passed)
//    private fun isTokenValid(keyTime: String, preferences: SharedPreferences): Boolean {
//        val previousTime = preferences.getLong(keyTime, 0)
//        val currentTime = System.currentTimeMillis()
//        return currentTime - previousTime < EXPIRATION_TIME
//    }
//
//    // Clear the stored CSRF token and expiration time
//    private fun clearToken(keyToken: String, keyExpirationTime: String, preferences: SharedPreferences) {
//        preferences.edit().remove(keyToken).remove(keyExpirationTime).apply()
//    }
//
//    fun getJWTToken(preferences: SharedPreferences): String {
//        val jwtToken = preferences.getString(KEY_JWT_TOKEN, "") ?: ""
//        if (isTokenValid(KEY_JWT_EXPIRATION_TIME, preferences)) return jwtToken
//        return ""
//    }
//
//    fun saveJWTToken(preferences: SharedPreferences, token: String) {
//        val currentTime = System.currentTimeMillis()
//        clearToken(KEY_JWT_TOKEN, KEY_JWT_EXPIRATION_TIME, preferences)
//        preferences.edit().putString(KEY_JWT_TOKEN, "Bearer $token").apply()
//        preferences.edit().putLong(KEY_JWT_EXPIRATION_TIME, currentTime).apply()
//
//        val jwtToken = preferences.getString(KEY_JWT_TOKEN, "") ?: ""
//    }
//
//}
