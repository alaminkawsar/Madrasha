package com.example.madrasha.presentation.student.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddStudentCard(
    modifier: Modifier = Modifier,
    onClose: () -> Unit
) {
    val focusManager = LocalFocusManager.current

    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 110.dp, bottom = 40.dp)
            .pointerInput(Unit) {
                detectTapGestures {
                    focusManager.clearFocus()
                }
            }, // 👈 leaves top background visible
        shape = RoundedCornerShape(30.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            // 🔹 Top Bar
            TopBar { onClose() }
            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

            Spacer(Modifier.height(12.dp))
            // 🔁 Scrollable Content
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item { InputTextField(title = "Student Name", "Enter Student Name") {} }
                item { DateSection(title = "Date of Birth") {} }
                item { InputTextField(title = "Father's Name *", "Enter Father's Name") {} }
                item { InputTextField(title = "Mother's Name *", "Enter Mother's Name") {} }
                item { InputTextField(title = "Guardian Name *", "Enter Guardian Name") {} }
                item { InputTextField(title = "Guardian Relation *", "Guardian Relation") {} }
                item { DateSection(title = "Admission Date") {} }
                item { InputTextField(title = "Address *", "Student address") {} }
                item { InputTextField(title = "Previous Institute", "Student address") {} }
                item { InputTextField(title = "Studies Course", "Student address") {} }
                item { InputTextField(title = "Course Enrolled *", "Student address") {} }
                item { DateSection(title = "Course Start Date *") {} }


                item { ActionButtons {} }
            }
        }
    }
}

@Composable
fun TopBar(onClose: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Add new student",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = onClose) {
            Icon(
                Icons.Default.Close,
                contentDescription = "Close",
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Composable
fun InputTextField(
    title: String,
    hits: String,
    onValueChange: (String) -> Unit

) {
    var value by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        SmallTextField(
            value = value,
            onValueChange = {
                value = it
                onValueChange(it)
            },
            hint = hits
        )
    }
}

@Composable
fun DateSection(
    title: String,
    onDateChange: (String) -> Unit
) {
    var date by remember { mutableStateOf("03/01/2026") } // TODO() it must be current date

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SmallTextField(
                value = date,
                onValueChange = { date = it },
                modifier = Modifier.weight(1f),
                hint = "pick transaction date",
                enabled = false
            )
            Spacer(Modifier.width(8.dp))
            IconButton(
                onClick = { /* select date */ },
                modifier = Modifier
                    .size(20.dp)
            ) {
                Icon(Icons.Default.CalendarToday, null)
            }
        }
    }
}

@Composable
fun ActionButtons(onDismiss: () -> Unit) {
    Spacer(Modifier.height(40.dp))

    Row {
        OutlinedButton(
            onClick = onDismiss,
            modifier = Modifier.weight(1f)
        ) {
            Text("Cancel")
        }

        Spacer(Modifier.width(12.dp))

        Button(
            onClick = { /* Save transaction */ },
            modifier = Modifier.weight(1f)
        ) {
            Text("Save")
        }
    }
}
