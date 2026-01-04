package com.example.madrasha.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.madrasha.core.component.NavigationDrawer
import com.example.madrasha.core.util.AdminDrawerScreen
import com.example.madrasha.presentation.admin.components.AdminDashboardContent
import com.example.madrasha.presentation.student.StudentScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeDashboardScreen(navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var currentScreen by remember { mutableStateOf<AdminDrawerScreen>(AdminDrawerScreen.DASHBOARD) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            NavigationDrawer(
                drawerState = drawerState,
                scope = scope,
            ) { item ->
                currentScreen = item
            }
        }
    ) {
        Scaffold(
            topBar = {
                HomeTopBar(
                    onMenuClick = {
                        scope.launch { drawerState.open() }
                    },
                    onLogoutClick = {
                        navController.popBackStack()
                    }
                )
            },
        ) { paddingValues ->
            val modifier = Modifier.padding(paddingValues)
            Column (modifier = modifier.padding()){
                HeaderSection()
                MainContent(currentScreen)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    onMenuClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    TopAppBar(
        title = {
            Icon(
                imageVector = Icons.Default.MenuBook,
                contentDescription = null,
                tint = Color(0xFF16A34A)
            )
        },
//        modifier = Modifier.shadow(),
        navigationIcon = {
            IconButton(onClick = {onMenuClick()}) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = {onLogoutClick()}) {
                Icon(Icons.Default.Logout, contentDescription = "Logout")
            }
        }
    )
}

@Composable
fun HeaderSection() {
    Column (modifier = Modifier.padding(16.dp)){
        Text(
            text = "Student Management",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Manage all student records and information",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun MainContent(currentScreen: AdminDrawerScreen) {
    when(currentScreen) {
        AdminDrawerScreen.COURSE -> TODO()
        AdminDrawerScreen.DASHBOARD -> {
            AdminDashboardContent()
        }
        AdminDrawerScreen.EXAM_AND_RESULT -> TODO()
        AdminDrawerScreen.MONTHLY_INPUT -> TODO()
        AdminDrawerScreen.NOTICE -> TODO()
        AdminDrawerScreen.STUDENT -> {
            StudentScreen()
        }
        AdminDrawerScreen.TEACHER -> TODO()
        AdminDrawerScreen.WEEKLY_INPUT -> TODO()
    }
}


