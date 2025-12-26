package com.example.madrasha

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.madrasha.core.util.AUTHENTICATION_ROUTE
import com.example.madrasha.core.util.Screen
import com.example.madrasha.presentation.SignInScreen
import com.example.madrasha.presentation.sign_in.LoginScreen

fun NavGraphBuilder.authenticationNav(
    navController: NavController,
//    sharedViewModel: CommonViewModel
) {
    navigation(startDestination = Screen.SignInScreen.route, route = AUTHENTICATION_ROUTE) {
//        lateinit var messengerViewModel: MessengerViewModel
        composable(route = Screen.SignInScreen.route) {
//            SignInScreen(navController = navController)
            LoginScreen(
            )
        }
//        composable(route = Screen.SignUpScreen.route) {
//            SignUpScreen(navController = navController, sharedViewModel, hiltViewModel())
//        }
//        composable(route = Screen.HomeScreen.route) {
//            HomeScreen(navController = navController, viewModel = sharedViewModel)
//        }
//        composable(route = Screen.MessengerScreen.route) {
//            messengerViewModel = hiltViewModel()
//            MessengerUI(navController = navController, viewModel = messengerViewModel)
//        }
//        composable(route = Screen.UserMessageUIScreen.route) {
//            UserMessageUI(
//                navController = navController,
//                viewModel = messengerViewModel
//            )
//        }
//        composable(route = Screen.SearchUIScreen.route) {
//            HomeSearchUI(navController = navController, viewModel = messengerViewModel)
//        }
    }
}