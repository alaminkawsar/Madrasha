package com.khidmah.madrasha.core.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CustomTopAppBar(
    @DrawableRes leadingIcon: Int,
    onClickLeadingIcon: () -> Unit = {},
    @DrawableRes trailingIcon: Int? = null,
    extraContent: @Composable () -> Unit = {},
    onClickTrailingIcon: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 24.dp, vertical = 8.dp)
        ) {
            IconButton(onClick = { onClickLeadingIcon() }) {
                Icon(
                    painter = painterResource(id = leadingIcon),
                    contentDescription = "Leading Icon",
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = CircleShape
                        )
                        .size(40.dp)
                        .padding(12.dp)
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                content()
            }
            Box(modifier = Modifier.size(40.dp)) {
                trailingIcon?.let {
                    IconButton(onClick = { onClickTrailingIcon() }) {
                        Icon(
                            painter = painterResource(id = it),
                            contentDescription = "Trailing Icon",
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray,
                                    shape = CircleShape
                                )
                                .fillMaxSize()
                                .padding(12.dp)
                        )
                    }
                }
            }
        }
        extraContent()
    }
}