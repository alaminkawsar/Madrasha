package com.khidmah.al_hisan.core.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khidmah.madrasha.R

@Composable
fun OutlineInputTextField(
    field: State<String>,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (value: String) -> Unit = {},
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
    onIconPressed: () -> Unit = {},
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isEnable: Boolean = true,
    imeAction: ImeAction = ImeAction.Next,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    isError: Boolean = false,
    errorMessage: String = "",
) {
    val iconSize = 20.dp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {

        if (leadingIcon != null) {
            OutlinedTextField(
                value = field.value,
                onValueChange = {
                    onValueChange(it)
                },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = leadingIcon),
                        contentDescription = "Leading Icon",
                        modifier = Modifier.size(iconSize)
                    )
                },
                trailingIcon = {
                    trailingIcon?.let {
                        IconButton(
                            onClick = {
                                onIconPressed()
                            },
                            enabled = isEnable
                        ) {
                            Icon(
                                painter = painterResource(id = trailingIcon),
                                contentDescription = "",
                                tint = colorResource(id = R.color.teal_200),
                                modifier = Modifier.size(iconSize)
                            )
                        }
                    }
                },
                singleLine = true,
//                placeholder = { Text(placeholder) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
                isError = isError,
                visualTransformation = visualTransformation,
                enabled = isEnable,
                shape = MaterialTheme.shapes.medium,
                keyboardActions = keyboardActions,
                textStyle = TextStyle(fontSize = 18.sp)
            )
            if (isError and errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red
                )
            }
        } else {
            OutlinedTextField(
                value = field.value,
                onValueChange = {
                    onValueChange(it)
                },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    trailingIcon?.let {
                        IconButton(
                            onClick = {
                                onIconPressed()
                            },
                            enabled = isEnable
                        ) {
                            Icon(
                                painter = painterResource(id = trailingIcon),
                                contentDescription = "",
                                tint = colorResource(id = R.color.teal_200),
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                },
                singleLine = true,
//                placeholder = { Text(placeholder) },
                label = { Text(placeholder) },
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                visualTransformation = visualTransformation,
                enabled = isEnable,
                shape = MaterialTheme.shapes.medium,
                textStyle = TextStyle(fontSize = 18.sp),
                isError = isError,
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = colorResource(id = R.color.app_primary_color),
//                    cursorColor = colorResource(id = R.color.app_primary_color),
//                    textColor = Color.Black,
//                    focusedLabelColor = colorResource(id = R.color.app_primary_color)
//                )
            )
            if (isError and errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red
                )
            }
        }
    }

}
//
//@Preview(showBackground = true)
//@Composable
//fun OutlineInputTextFieldPreview() {
//    val field = remember {
//        mutableStateOf("")
//    }
//    AlHisanTheme {
//        OutlineInputTextField(
//            label = "First name",
//            field = field,
//            onValueChange = {},
//            placeholder = "Text field",
//            keyboardType = KeyboardType.Text,
//            leadingIcon = R.drawable.search
//        )
//    }
//}