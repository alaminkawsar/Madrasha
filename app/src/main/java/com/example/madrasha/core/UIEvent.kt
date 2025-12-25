package com.example.madrasha.core

sealed class UIEvent {
    data class ShowSnackBar(val message: String) : UIEvent()
    data class ShowToastMessage(val message: String) : UIEvent()
}