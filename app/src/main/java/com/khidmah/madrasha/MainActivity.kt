package com.khidmah.madrasha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.khidmah.madrasha.core.util.AUTHENTICATION_ROUTE
import com.khidmah.madrasha.core.util.ROOT_ROUTE
import com.khidmah.madrasha.ui.theme.MadrashaAppTheme

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