package com.example.madrasha.presentation.admin.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AdminDashboardContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
//        item { DashboardStatsGrid() }
//
//        item { RecentStudentsCard() }
//
//        item { RecentNoticesCard() }

        DashboardStatsGrid()
        RecentStudentsCard()
        RecentNoticesCard()
    }
}

@Composable
fun DashboardStatsGrid() {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        StatCard("Total Students", "3", Icons.Default.People, Color(0xFF2979FF))
        StatCard("Total Teachers", "4", Icons.Default.School, Color(0xFF00C853))
        StatCard("Active Courses", "4", Icons.Default.MenuBook, Color(0xFFAA00FF))
        StatCard("Active Notices", "4", Icons.Default.TrendingUp, Color(0xFFFF6D00))
    }
}

@Composable
fun StatCard(
    title: String,
    value: String,
    icon: ImageVector,
    iconColor: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(title, style = MaterialTheme.typography.bodyMedium)
                Text(value, style = MaterialTheme.typography.headlineSmall)
            }

            Box(
                modifier = Modifier
                    .size(44.dp)
                    .background(iconColor, shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = title, tint = Color.White)
            }
        }
    }
}

@Composable
fun RecentStudentsCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                "Recent Students",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(12.dp))

            StudentItem("Ali Hassan", "Advanced Quran & Hadith Studies", "S001")
            Divider()
            StudentItem("Fatima Zahra", "Hifz & Tajweed Program", "S002")
            Divider()
            StudentItem("Muhammad Ibrahim", "Advanced Islamic Jurisprudence", "S003")
            Divider()
            StudentItem("Ayesha Siddika", "Arabic Language Studies", "S004")
        }
    }
}
@Composable
fun StudentItem(
    name: String,
    program: String,
    id: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(name, style = MaterialTheme.typography.bodyMedium)
            Text(
                program,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }

        Text(
            id,
            color = Color(0xFF00C853),
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun RecentNoticesCard() {
    Card(
        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                "Recent Notices",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(12.dp))

            NoticeItem("Upcoming Ramadan Schedule", "2024-11-20")
            Divider()
            NoticeItem("Mid-Term Examinations", "2024-11-18")
            Divider()
            NoticeItem("Islamic Knowledge Competition", "2024-11-15")
        }
    }
}
@Composable
fun NoticeItem(
    title: String,
    date: String
) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(title, style = MaterialTheme.typography.bodyMedium)
        Text(
            date,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
    }
}


