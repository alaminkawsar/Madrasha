package com.khidmah.madrasha.presentation.sign_in

import androidx.compose.runtime.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.khidmah.madrasha.R
import com.khidmah.madrasha.core.util.Screen

@Composable
fun SignInScreen(
    navController: NavController,
//    commonViewModel: CommonViewModel,
//    viewModel: SignInViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(key1 = true) {
//        viewModel.onEvent(SignInEvent.EnteredEmail(commonViewModel.email.value))
//        viewModel.onEvent(SignInEvent.EnteredPassword(commonViewModel.password.value))
//        viewModel.eventFlow.collect { event ->
//            when (event) {
//                is UIEvent.ShowSnackBar -> {
//                    scaffoldState.snackbarHostState.showSnackbar(event.message)
//                }
//
//                is UIEvent.ShowToastMessage -> {
//                    Toast.makeText(context, event.message, Toast.LENGTH_LONG).show()
//                }
//            }
//        }
    }
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {

        }
    ) { scrollPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(scrollPadding)
                .verticalScroll(scrollState)  // Make the content scrollable
                .imePadding()
                .background(Color.White)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(), // Fill the entire screen
                contentAlignment = Alignment.Center // Align content in the center
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineLarge,
                        color = colorResource(id = R.color.teal_200)
                    )
                    Spacer(modifier = Modifier.width(16.dp)) // Adds a gap of 16.dp between text and image
//                    Image(
//                        painter = painterResource(id = R.drawable.white_pigeon_1),
//                        contentDescription = stringResource(id = R.string.app_name),
//                        modifier = Modifier
//                            .height(30.dp),
//                        colorFilter = ColorFilter.tint(colorResource(id = R.color.app_primary_color)) // Change color to black
//                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {

//                OutlineInputTextField(
//                    field = viewModel.email,
//                    onValueChange = {
//                        viewModel.onEvent(SignInEvent.EnteredEmail(it))
//                    },
//                    onIconPressed = {},
//                    placeholder = stringResource(id = R.string.label_email_or_phone),
//                    keyboardType = KeyboardType.Text,
//                    isError = !viewModel.isValidEmail.value,
//                    errorMessage = "\t*" + stringResource(id = R.string.error_email_or_phone)
//                )
                Spacer(modifier = Modifier.height(16.dp))

//                OutlineInputTextField(
//                    field = viewModel.password,
//                    onValueChange = {
//                        viewModel.onEvent(SignInEvent.EnteredPassword(it))
//                    },
//                    trailingIcon = if (viewModel.showPassword.value) {
//                        R.drawable.eye_open_gray
//                    } else {
//                        R.drawable.eye_close_gray
//                    },
//                    onIconPressed = {
//                        viewModel.onEvent(SignInEvent.ShowPassword)
//                    },
//                    placeholder = "Password",
//                    keyboardType = KeyboardType.Password,
//                    visualTransformation = if (viewModel.showPassword.value) {
//                        VisualTransformation.None
//                    } else {
//                        PasswordVisualTransformation()
//                    },
//                    imeAction = ImeAction.Done,
//                )
                Spacer(modifier = Modifier.height(16.dp))
//                if (viewModel.showInvalidCredentialErrorMessage.value) {
//                    Text(
//                        text = stringResource(id = R.string.error_invalid_user_name_pass),
//                        color = Color.Red,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                    )
//                    Spacer(modifier = Modifier.height(16.dp))
//                }
//                Text(
//                    text = stringResource(id = R.string.password_forget),
//                    textAlign = TextAlign.Right,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable {
////                            navController.navigate(Screen.ResetPasswordScreen.route)
//                        },
//                    color = Green20
//                )
                Spacer(modifier = Modifier.height(16.dp))
//                Button(
//                    onClick = {
//                        keyboardController?.hide()  // Hides the keyboard on button click
//                        focusManager.clearFocus()
//                        viewModel.onEvent(SignInEvent.SignInButtonClick {
//                            navController.popBackStack()
//                            // navController.navigate(Screen.HomeScreen.route)
//                            navController.navigate(Screen.MessengerScreen.route)
//                        })
//                    },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clip(RoundedCornerShape(10.dp)),
//                    colors = ButtonDefaults.buttonColors(
//                        backgroundColor = LightGreen
//                    )
//                ) {
////                    if (viewModel.isLoading.value) {
////                        CircularProgressIndicator(
////                            color = Color.White,
////                            modifier = Modifier.size(25.dp)
////                        )
////                    } else {
////                        Text(
////                            text = stringResource(id = R.string.btn_text_signUp),
////                            modifier = Modifier
////                                .padding(vertical = 12.dp),
////                            fontWeight = FontWeight.Bold,
////                            color = Color.White,
////                            fontSize = 16.sp
////                        )
////                    }
//                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row {
                    Text(text = stringResource(id = R.string.have_any_account))
                    Text(
                        text = stringResource(id = R.string.btn_text_signUp),
                        color = Color(0xFF1176B4),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .clickable {
                                navController.navigate(Screen.SignUpScreen.route)
                            }
                    )
                }
            }
        }
    }
}