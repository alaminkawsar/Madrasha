//package com.example.al_hisan.core.component
//
//import androidx.annotation.DrawableRes
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.material.Icon
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.example.al_hisan.R
//import com.example.al_hisan.ui.theme.AlHisanTheme
//
//@Composable
//fun ReactionBottomBar(
//    likeCount: Int,
//    commentCount: Int
//) {
//    Row(
//        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        Reaction(iconName="like", iconCount = likeCount, reactionIcon = R.drawable.ic_like)
//        Reaction(iconName="comment", iconCount = commentCount, reactionIcon = R.drawable.ic_comment)
//        Reaction(iconName="share", iconCount = 0, reactionIcon = R.drawable.ic_share)
//    }
//
//}
//
//@Composable
//fun Reaction(
//    iconName: String,
//    iconCount: Int,
//    @DrawableRes reactionIcon: Int,
//    iconSize: Int = 20
//) {
//    Row(horizontalArrangement = Arrangement.Center,
//        verticalAlignment = Alignment.CenterVertically) {
//        Icon(
//            painter = painterResource(id = reactionIcon),
//            contentDescription = "Reaction icon",
//            modifier = Modifier.size(iconSize.dp)
//        )
//        Spacer(modifier = Modifier.width(10.dp))
//        if (iconCount>0) {
//            Text(text = "$iconCount")
//        }
//    }
//
//}
//
//@Preview(showBackground = true)
//@Composable
//fun ReactionBottomBarPreview() {
//    AlHisanTheme {
//        ReactionBottomBar(
//            likeCount = 114,
//            commentCount = 28
//        )
//    }
//}