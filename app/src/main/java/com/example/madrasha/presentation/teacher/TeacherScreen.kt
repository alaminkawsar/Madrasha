package com.example.madrasha.presentation.teacher


import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.madrasha.core.component.CustomSearchBar
import com.example.madrasha.presentation.HeaderSection
import com.example.madrasha.presentation.teacher.components.AddTeacherCard

@Composable
fun TeacherScreen() {
    val teachers = remember {
        listOf(
            Teacher("T001", "Ustad Ali Hassan", "Quran and Tazwid"),
            Teacher("T002", "Ustaza Fatima Zahra", "Hadith Studies"),
            Teacher("T003", "Ustad Muhammad Ibrahim", "Islamic History")
        )
    }
    var showSheet by remember { mutableStateOf(false) }

    Box {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            HeaderSection()
            Spacer(modifier = Modifier.height(8.dp))
            AddTeacherButton() {
                showSheet = true
            }

            Spacer(modifier = Modifier.height(16.dp))
            TeacherListCard(teachers)

        }
        if (showSheet) {
            AddTeacherCard {
                showSheet = false
            }
        }
    }
}

@Composable
fun AddTeacherButton(
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF16A34A)),
        shape = RoundedCornerShape(10.dp)
    ) {
        Icon(Icons.Default.Add, contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text("Add Teacher")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeacherListCard(teachers: List<Teacher>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "All Teachers (${teachers.size})",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))
            CustomSearchBar(
                hint = "Search Teacher"
            ) { }
            Spacer(modifier = Modifier.height(8.dp))
            TeacherTable(teachers)
        }
    }
}
@Composable
fun TeacherTable(teachers: List<Teacher>) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scrollState)
    ) {
        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ) {
            TableHeader()
            teachers.forEach {
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp
                )
                TableRow(it)
            }
        }
    }
}

@Composable
fun TableHeader() {
    Row(modifier = Modifier.padding(vertical = 8.dp)) {
        TableCell("ID", true)
        TableCell("Name", true)
        TableCell("Father's Name", true)
    }
}

@Composable
fun TableRow(teacher: Teacher) {
    Row(modifier = Modifier.padding(vertical = 6.dp)) {
        TableCell(teacher.id)
        TableCell(teacher.name)
        TableCell(teacher.fatherName)
    }
}

@Composable
fun TableCell(text: String, isHeader: Boolean = false) {
    Text(
        text = text,
        modifier = Modifier.width(140.dp),
        fontWeight = if (isHeader) FontWeight.Bold else FontWeight.Normal
    )
}

data class Teacher(
    val id: String,
    val name: String,
    val fatherName: String
)
