package com.example.madrasha.core.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.madrasha.ui.theme.MadrashaAppTheme

@Composable
fun LargeButton(
    text: String,
    textColor: Color = Color.White,
    @DrawableRes icon: Int? = null,
    iconColor: Color = MaterialTheme.colorScheme.primary,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    isEnable: Boolean = false,
    disabledBackgroundColor: Color = Color.Green,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        enabled = isEnable,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        icon?.let {
            Icon(painter = painterResource(id = icon), contentDescription = text, tint = iconColor)
        }
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold,
            color = textColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LargeButtonPreview() {
    MadrashaAppTheme {
        LargeButton(text = "Apply")
    }
}