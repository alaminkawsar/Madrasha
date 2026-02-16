package com.khidmah.madrasha.presentation.sign_in

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khidmah.al_hisan.ui.theme.Green
import com.khidmah.al_hisan.ui.theme.PrimaryGreen
import com.khidmah.al_hisan.ui.theme.Red
import com.khidmah.madrasha.core.util.UserRole

@Composable
fun LoginScreen(onLoginSuccess: (UserRole, String, String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Red)
    ) {
        // 🌿 Top Section (Logo + Text)
        TopSection()
        // 📦 Login Card
        LoginCard(
            onLoginSuccess = onLoginSuccess,
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

@Composable
private fun TopSection() {
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
}

@Composable
private fun LoginHeader() {
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RoleSelection(
    expandedStatus: Boolean,
    selectedRole: UserRole,
    onRoleSelected: (UserRole) -> Unit,
    onExpansionChanged: (Boolean) -> Unit
) {
    // Role
    Text("Select Role, ", fontWeight = FontWeight.SemiBold)

    Spacer(modifier = Modifier.height(6.dp))

    ExposedDropdownMenuBox(
        expanded = expandedStatus,
        onExpandedChange = {
            if(expandedStatus) {
                onExpansionChanged(false)
            } else {
                onExpansionChanged(true)
            }
        }
    ) {
        OutlinedTextField(
            value = selectedRole.name,
            onValueChange = {
            },
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expandedStatus)
            },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expandedStatus,
            onDismissRequest = {
                onExpansionChanged(false)
            }
        ) {
            listOf("ADMIN", "TEACHER", "STUDENT").forEach {
                DropdownMenuItem(
                    text = { Text(it) },
                    onClick = {
                        onRoleSelected(UserRole.valueOf(it))
                        onExpansionChanged(false)
                    }
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(12.dp))

}

@Composable
private fun UserNameField(username: String, onValueChange: (String) -> Unit) {
    // Username
    Text("Username", fontWeight = FontWeight.SemiBold)
    Spacer(modifier = Modifier.height(6.dp))
    OutlinedTextField(
        value = username,
        onValueChange = { onValueChange(it) },
        placeholder = { Text("Enter username") },
        leadingIcon = {
            Icon(Icons.Default.Person, contentDescription = null)
        },
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(12.dp))
}

@Composable
private fun PasswordField(password: String, onValueChange: (String) -> Unit) {
    // Password
    Text("Password", fontWeight = FontWeight.SemiBold)
    Spacer(modifier = Modifier.height(6.dp))
    OutlinedTextField(
        value = password,
        onValueChange = { onValueChange(it) },
        placeholder = { Text("Enter password") },
        leadingIcon = {
            Icon(Icons.Default.Lock, contentDescription = null)
        },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
private fun SignInButton(onClickListener: () -> Unit) {
    // Sign In Button
    Button(
        onClick = {
            onClickListener()
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginCard(
    onLoginSuccess: (UserRole, String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    val TAG = "LoginCard"
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var selectedRole by remember { mutableStateOf(UserRole.ADMIN) }
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            LoginHeader()
            RoleSelection(
                expanded,
                selectedRole,
                onRoleSelected = {
                    selectedRole = it
                    Log.d(TAG, "onRoleSelected: $it")
                },
                onExpansionChanged = {
                    expanded = it
                    Log.d(TAG, "onExpansionChanged: $it")
                })
            UserNameField(username = username, onValueChange = { username = it })
            PasswordField(password = password, onValueChange = { password = it })
            SignInButton {
                val role = UserRole.ADMIN
                // UserRole.valueOf(selectedRole.name) TODO: [Update by this code when ready]
                onLoginSuccess(role, username, password)
            }
        }
    }
}


