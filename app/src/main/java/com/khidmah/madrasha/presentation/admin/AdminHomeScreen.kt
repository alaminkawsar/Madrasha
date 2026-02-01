package com.khidmah.madrasha.presentation.admin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavController
import com.khidmah.madrasha.core.component.NavigationDrawer
import com.khidmah.madrasha.core.util.AdminDrawerScreen
import com.khidmah.madrasha.presentation.admin.course.CoursesScreen
import com.khidmah.madrasha.presentation.admin.dashboard.AdminDashboardContent
import com.khidmah.madrasha.presentation.admin.exam_result.ExamResultsScreen
import com.khidmah.madrasha.presentation.admin.monthly_input.MonthlyInputScreen
import com.khidmah.madrasha.presentation.admin.monthly_input.WeeklyInputScreen
import com.khidmah.madrasha.presentation.admin.notice.NoticeScreen
import com.khidmah.madrasha.presentation.admin.student.StudentScreen
import com.khidmah.madrasha.presentation.admin.teacher.TeacherScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminHomeScreen(navController: NavController) {
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
            Column (modifier = modifier){
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
fun MainContent(currentScreen: AdminDrawerScreen) {
    when(currentScreen) {
        AdminDrawerScreen.COURSE -> CoursesScreen()
        AdminDrawerScreen.DASHBOARD -> AdminDashboardContent()
        AdminDrawerScreen.EXAM_AND_RESULT -> ExamResultsScreen()
        AdminDrawerScreen.MONTHLY_INPUT -> MonthlyInputScreen()
        AdminDrawerScreen.NOTICE -> NoticeScreen()
        AdminDrawerScreen.STUDENT -> StudentScreen()
        AdminDrawerScreen.TEACHER -> TeacherScreen()
        AdminDrawerScreen.WEEKLY_INPUT -> WeeklyInputScreen()
    }
}


