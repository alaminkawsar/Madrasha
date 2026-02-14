package com.khidmah.madrasha

import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.khidmah.madrasha.core.util.ADMIN_ROUTE
import com.khidmah.madrasha.core.util.AUTHENTICATION_ROUTE
import com.khidmah.madrasha.core.util.GUARDIAN_ROUTE
import com.khidmah.madrasha.core.util.STUDENT_ROUTE
import com.khidmah.madrasha.core.util.Screen
import com.khidmah.madrasha.core.util.TEACHER_ROUTE
import com.khidmah.madrasha.core.util.UserRole
import com.khidmah.madrasha.presentation.admin.AdminHomeScreen
import com.khidmah.madrasha.presentation.sign_in.LoginScreen
fun NavGraphBuilder.authenticationNav(
    navController: NavController,
//    sharedViewModel: CommonViewModel
) {
    val TAG = "[authenticationNav]"
    navigation(startDestination = Screen.SignInScreen.route, route = AUTHENTICATION_ROUTE) {
        composable(route = Screen.SignInScreen.route) {
            LoginScreen { role, username, password ->
                Log.d(TAG, "SignInButton tapped for : " +
                        "userName: $username, " +
                        "password: $password " +
                        "role: ${role.name} ")
                navController.navigationScreen(role)
            }
        }
        composable(route = ADMIN_ROUTE) {
            AdminHomeScreen(navController)
        }
    }
}
private fun NavController.navigationScreen(role: UserRole) {
    when (role) {
        UserRole.ADMIN -> navigate(ADMIN_ROUTE)
        UserRole.TEACHER -> navigate(TEACHER_ROUTE)
        UserRole.STUDENT -> navigate(STUDENT_ROUTE)
        UserRole.GUARDIAN -> navigate(GUARDIAN_ROUTE)
    }
}


