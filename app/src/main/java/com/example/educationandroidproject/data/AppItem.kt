package com.example.educationandroidproject.data

import androidx.annotation.DrawableRes

data class AppItem(
    @DrawableRes val icon: Int,
    val nameApp: String,
    val description: String,
    val category: String
)
