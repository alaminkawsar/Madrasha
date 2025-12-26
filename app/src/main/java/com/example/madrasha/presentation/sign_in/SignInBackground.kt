package com.example.madrasha.presentation.sign_in

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.al_hisan.ui.theme.Green
import com.example.al_hisan.ui.theme.Green20
import com.example.al_hisan.ui.theme.PrimaryGreen
import com.example.al_hisan.ui.theme.SoftGreen
import com.example.madrasha.core.util.ADMIN_ROUTE
import com.example.madrasha.core.util.GUARDIAN_ROUTE
import com.example.madrasha.core.util.STUDENT_ROUTE
import com.example.madrasha.core.util.TEACHER_ROUTE
import com.example.madrasha.core.util.UserRole

@Composable
fun LoginScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SoftGreen)
    ) {

        // 🌿 Top Section (Logo + Text)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            // Book Icon
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(PrimaryGreen, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.MenuBook,
                    contentDescription = "Book",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Islamic School Management System",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Assalamu Alaikum - Welcome to our learning portal",
                fontSize = 16.sp,
                color = Green,
                textAlign = TextAlign.Center
            )
        }

        // 📦 Login Card
        LoginCard(
            navController = navController,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(
                    top = 230.dp,   // 👈 creates space from background text
                    start = 20.dp,
                    end = 20.dp
                )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginCard(
    navController: NavController,
    modifier: Modifier = Modifier
) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var selectedRole by remember { mutableStateOf("Admin") }
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = "Login to Your Account",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Text(
                text = "Enter your credentials to access the system",
                fontSize = 13.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Role
            Text("Select Role", fontWeight = FontWeight.SemiBold)

            Spacer(modifier = Modifier.height(6.dp))

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = selectedRole,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    listOf("Admin", "Teacher", "Student").forEach {
                        DropdownMenuItem(
                            text = { Text(it) },
                            onClick = {
                                selectedRole = it
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Username
            Text("Username", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                placeholder = { Text("Enter username") },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = null)
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Password
            Text("Password", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Enter password") },
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = null)
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Sign In Button
            Button(
                onClick = {
                    val role = UserRole.ADMIN
                    when (role) {
                        UserRole.ADMIN -> navController.navigate(ADMIN_ROUTE)
                        UserRole.TEACHER -> navController.navigate(TEACHER_ROUTE)
                        UserRole.STUDENT -> navController.navigate(STUDENT_ROUTE)
                        UserRole.GUARDIAN -> navController.navigate(GUARDIAN_ROUTE)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryGreen
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text("Sign In", color = Color.White)
            }
        }
    }
}
