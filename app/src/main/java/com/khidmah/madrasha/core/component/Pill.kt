//package com.example.al_hisan.core.component
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Color.Companion.Green
//import androidx.compose.ui.graphics.Color.Companion.Red
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.ExperimentalUnitApi
//import androidx.compose.ui.unit.TextUnit
//import androidx.compose.ui.unit.TextUnitType
//import androidx.compose.ui.unit.dp
//import com.example.al_hisan.ui.theme.AlHisanTheme
//import com.example.al_hisan.ui.theme.Red200
//import com.example.al_hisan.ui.theme.Yellow
//
//@OptIn(ExperimentalUnitApi::class)
//@Composable
//fun Pill(text: String, textColor: Color, backgroundColor: Color) {
//    Text(
//        text = text,
//        color = textColor,
//        style = MaterialTheme.typography.caption,
//        fontWeight = FontWeight.W700,
//        fontSize = TextUnit(12f, TextUnitType.Sp),
//        modifier = Modifier
//            .padding(vertical = 3.dp)
//            .background(color = backgroundColor, shape = RoundedCornerShape(5.dp))
//            .padding(horizontal = 6.dp, vertical = 3.dp)
//    )
//}
//
//@Preview(showBackground = false)
//@Composable
//fun GreenPillPreview() {
//    AlHisanTheme {
//        Pill(
//            "General",
//            textColor = Green,
//            backgroundColor = Green
//        )
//    }
//}
//
//@Preview(showBackground = false)
//@Composable
//fun RedPillPreview() {
//    AlHisanTheme {
//        Pill(
//            "General",
//            textColor = Red,
//            backgroundColor = Red200
//        )
//    }
//}
//
//@Preview(showBackground = false)
//@Composable
//fun YellowPillPreview() {
//    AlHisanTheme {
//        Pill(
//            "General",
//            textColor = Color.Black,
//            backgroundColor = Yellow
//        )
//    }
//}