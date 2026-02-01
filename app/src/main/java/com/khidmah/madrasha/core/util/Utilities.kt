package com.khidmah.madrasha.core.util

import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar

object Utilities {
    const val userId: String = "user_id"
    const val firstName: String = "first_name"
    fun currentDate(): String {
        val currentDate = Calendar.getInstance()
        val day = currentDate.get(Calendar.DATE)
        val month = currentDate.get(Calendar.MONTH)
        val year = currentDate.get(Calendar.YEAR)
        return "$month/$day/$year"
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun formatDateString(input: String): String {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS")
        val outputFormatter = DateTimeFormatter.ofPattern("HH:mm a  MMM dd, yyyy")

        val dateTime = LocalDateTime.parse(input, inputFormatter)
        return dateTime.format(outputFormatter)
    }

    fun parseColor(colorString: String): Triple<Int, Int, Int> {
        val regex = """rgb\((\d+), (\d+), (\d+)\)""".toRegex()
        val matchResult = regex.find(colorString)

        return if (matchResult != null) {
            val (red, green, blue) = matchResult.destructured
            return Triple(red.toInt(), green.toInt(), blue.toInt())
        } else {
            // Default color in case of parsing error
            Triple(0, 0, 0)
        }
    }

    fun currentTime(): String {
        val currentDate = Calendar.getInstance()
        val hour = currentDate.get(Calendar.HOUR)
        val minute = currentDate.get(Calendar.MINUTE)
        val amOrPm = if (currentDate.get(Calendar.AM_PM) == 0) {
            "AM"
        } else {
            "PM"
        }
        return "$hour:$minute $amOrPm"
    }
//
//    fun getPatient(preferences: SharedPreferences): Patient {
//        return Patient(
//            firstName = preferences.getString(Patient.FIRST_NAME, "") ?: "",
//            lastName = preferences.getString(Patient.LAST_NAME, "") ?: "",
//            patientId = preferences.getString(Patient.PATIENT_ID, "") ?: "",
//            tenant = preferences.getString(Patient.TENANT, "") ?: "emma",
//            email = preferences.getString(Patient.EMAIL, "") ?: "",
//            loggedIn = preferences.getBoolean(Patient.LOGGED_IN, false),
//            walkThroughPageShown = preferences.getBoolean(Patient.WALK_THROUGH_SHOWN, false),
//        )
//    }
//
//    fun savePatient(preferences: SharedPreferences, data: Patient) {
//        preferences.edit().apply {
//            putString(Patient.FIRST_NAME, data.firstName)
//            putString(Patient.LAST_NAME, data.lastName)
//            putString(Patient.PATIENT_ID, data.patientId)
//            putString(Patient.TENANT, data.tenant)
//            putString(Patient.EMAIL, data.email)
//            putBoolean(Patient.LOGGED_IN, data.loggedIn)
//            putBoolean(Patient.WALK_THROUGH_SHOWN, data.walkThroughPageShown)
//            apply()
//        }
//    }
    fun saveAuthorId(preferences: SharedPreferences, id: String) {
        preferences.edit().putString(userId, id).apply()
    }
    fun getAuthorId(preferences: SharedPreferences): String {
        return preferences.getString(userId, "") ?: ""
    }


}