//package com.example.al_hisan.core.component
//
//import androidx.annotation.DrawableRes
//import androidx.compose.material.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.al_hisan.ui.theme.AlHisanTheme
//import com.example.al_hisan.ui.theme.Blue50
//import com.example.madrasha.core.component.LargeButton
//
//@Composable
//fun SecondaryLargeButton(
//    text: String,
//    @DrawableRes icon: Int? = null,
//    isEnable: Boolean = true,
//    onClick: () -> Unit = {}
//) {
//    LargeButton(
//        text = text,
//        textColor = MaterialTheme.colors.primary,
//        icon = icon,
//        iconColor = MaterialTheme.colors.onPrimary,
//        backgroundColor = Blue50,
//        isEnable = isEnable,
//        disabledBackgroundColor = Blue50,
//        onClick = onClick
//    )
//}
//
//@Preview
//@Composable
//fun SecondaryLargeButtonPreview() {
//    AlHisanTheme {
//        SecondaryLargeButton(text = "Sign In")
//    }
//}