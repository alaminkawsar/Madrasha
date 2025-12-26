package com.example.madrasha.core.util

const val ROOT_ROUTE = "root"
const val AUTHENTICATION_ROUTE = "authentication"
const val ADMIN_ROUTE = "admin"
const val TEACHER_ROUTE = "teacher"
const val STUDENT_ROUTE = "student"
const val GUARDIAN_ROUTE = "guardian"

sealed class Screen(val route: String) {
    object SignInScreen : Screen("sign_in_screen")
    object SignUpScreen : Screen("sign_up_screen")
    object ResetPasswordScreen : Screen("reset_password_screen")
    object RecoveryPasswordScreen : Screen("recovery_password_screen")
    object HomeScreen : Screen("home_screen")
    object NotificationScreen : Screen("notification_screen")
    object SettingsScreen : Screen("settings_screen")
    object MessengerScreen: Screen("Messenger")
    object UserMessageUIScreen: Screen("user_message_ui_screen")
    data object SearchUIScreen: Screen("search_ui_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}