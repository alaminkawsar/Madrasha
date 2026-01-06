package com.example.madrasha.presentation.admin.student.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun SmallTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hint: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    enabled: Boolean = true
) {
    var isFocused by remember { mutableStateOf(false) }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 15.sp,
            color = Color.Black
        ),
        keyboardOptions = keyboardOptions,
        modifier = modifier
            .height(36.dp)
            .fillMaxWidth()
            .onFocusChanged { isFocused = it.isFocused }

            // 🔵 WIDER BLUE SHADOW (outside border)
            .shadow(
                elevation = if (isFocused) 12.dp else 0.dp, // ⬅ increased
                shape = RoundedCornerShape(8.dp),
                ambientColor = Color(0xFF4A6CF7).copy(alpha = 0.20f),
                spotColor = Color(0xFF4A6CF7).copy(alpha = 0.30f)
            )
            .background(
                color = Color(0xFFF2F2F2),
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = if (isFocused) 1.dp else 0.dp,
                color = if (isFocused) Color.Gray else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 12.dp, vertical = 8.dp),
        decorationBox = { innerTextField ->
            if (value.isEmpty()) {
                Text(
                    text = hint,
                    fontSize = 13.sp,
                    color = Color.Gray
                )
            }
            innerTextField()
        },
    )
}
