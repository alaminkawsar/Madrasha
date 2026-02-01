package com.khidmah.madrasha.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.khidmah.madrasha.core.util.AdminDrawerScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawer(
    drawerState: DrawerState,
    scope: CoroutineScope,
    selectedItem: (AdminDrawerScreen) -> Unit,
) {
    val configuration = LocalConfiguration.current
    val drawerWidth = configuration.screenWidthDp.dp * 2 / 3
    var prevItem by remember { mutableStateOf<AdminDrawerScreen>(AdminDrawerScreen.DASHBOARD) }
    var selected by remember { mutableStateOf(false) }

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
        getNavDrawerItem().forEach { (keyName, title, icon) ->
            selected = prevItem==keyName
            DrawerItem(title, icon, selected) {
                prevItem = keyName
                selectedItem(keyName)
                scope.launch { drawerState.close() }
            }
        }
    }
}


@Composable
fun DrawerItem(
    title: String,
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit,
) {
    NavigationDrawerItem(
        label = { Text(title) },
        selected = selected,
        onClick = {
            onClick()
        },
        icon = {
            Icon(icon, contentDescription = title)
        },
        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
    )
}

data class NavDrawerItem(
    val keyName: AdminDrawerScreen,
    val title: String,
    val icon: ImageVector
)

private fun getNavDrawerItem(): List<NavDrawerItem> {
    return listOf(
        NavDrawerItem(AdminDrawerScreen.DASHBOARD, "Dashboard", Icons.Default.Dashboard),
        NavDrawerItem(AdminDrawerScreen.STUDENT, "Students", Icons.Default.People),
        NavDrawerItem(AdminDrawerScreen.TEACHER, "Teachers", Icons.Default.School),
        NavDrawerItem(AdminDrawerScreen.COURSE, "Courses", Icons.Default.MenuBook),
        NavDrawerItem(
            AdminDrawerScreen.WEEKLY_INPUT,
            "Weekly Input",
            Icons.Default.EditCalendar
        ),
        NavDrawerItem(
            AdminDrawerScreen.MONTHLY_INPUT,
            "Monthly Input",
            Icons.Default.DateRange
        ),
        NavDrawerItem(
            AdminDrawerScreen.EXAM_AND_RESULT,
            "Exams & Results",
            Icons.Default.Assignment
        ),
        NavDrawerItem(AdminDrawerScreen.NOTICE, "Notices", Icons.Default.Notifications),
    )
}
