package com.example.madrasha.presentation.admin.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Assignment
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AdminDrawer(
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    val configuration = LocalConfiguration.current
    val drawerWidth = configuration.screenWidthDp.dp * 2 / 3

    ModalDrawerSheet(
        modifier = Modifier.width(drawerWidth)
    ) {
        // Top row with title + close icon
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Islamic School",
                style = MaterialTheme.typography.titleLarge
            )

            IconButton(
                onClick = {
                    scope.launch { drawerState.close() }
                }
            ) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Close Drawer"
                )
            }
        }

        Divider()

        Spacer(Modifier.height(8.dp))

        DrawerItem("Dashboard", Icons.Default.Dashboard)
        DrawerItem("Students", Icons.Default.People)
        DrawerItem("Teachers", Icons.Default.School)
        DrawerItem("Courses", Icons.Default.MenuBook)
        DrawerItem("Weekly Input", Icons.Default.EditCalendar)
        DrawerItem("Monthly Input", Icons.Default.DateRange)
        DrawerItem("Exams & Results", Icons.Default.Assignment)
        DrawerItem("Notices", Icons.Default.Notifications)
    }
}


@Composable
fun DrawerItem(title: String, icon: ImageVector) {
    NavigationDrawerItem(
        label = { Text(title) },
        selected = false,
        onClick = { },
        icon = {
            Icon(icon, contentDescription = title)
        },
        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
    )
}
