package com.khidmah.al_hisan.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AlertDialogMessage(
    title: String = "Confirmation",
    text: String = "",
    showDialog: Boolean,
    onConfirm: () -> Unit,
    onCancel: () -> Unit
) {

    val openDialog = remember { mutableStateOf(showDialog)  }
    if (openDialog.value){
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
                onCancel()
            },
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = title)
                }
            },
            text = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = text)
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                        onConfirm()
                    }) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        openDialog.value = false
                        onCancel()
                    }
                ) {
                    Text(text = "Cancel")
                }
            }
        )
    }


}