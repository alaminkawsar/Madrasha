package com.example.madrasha.core.util

sealed class HomeDashBoardView(val appViewType: String) {
    object Home : HomeDashBoardView("home")
    object Friends : HomeDashBoardView("friends")
    object Notifications : HomeDashBoardView("notifications")
    object Messenger: HomeDashBoardView("messenger")
    object Videos: HomeDashBoardView("videos")
}
