package com.khidmah.madrasha.core.util

object Urls {
    fun get(type: String): String {
        return when (type.lowercase()) {
            "base" -> "https://meccwave-production.up.railway.app"
            "dev" -> ""
            else -> ""
        }
    }
}