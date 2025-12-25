package com.example.madrasha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.ComposeView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.madrasha.core.util.AUTHENTICATION_ROUTE
import com.example.madrasha.core.util.ROOT_ROUTE
import com.example.madrasha.ui.theme.MadrashaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MadrashaAppTheme {
                val navController = rememberNavController()
//                val sharedViewModel: CommonViewModel = hiltViewModel()
                NavHost(
                    navController = navController,
                    startDestination = AUTHENTICATION_ROUTE,
                    route = ROOT_ROUTE
                ) {
                    authenticationNav(
                        navController = navController,
//                        sharedViewModel = sharedViewModel
                    )
                }
            }
        }
    }
}