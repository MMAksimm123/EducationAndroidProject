package com.example.educationandroidproject.data

import androidx.annotation.DrawableRes

data class AppItem(
    val id: Int,
    @DrawableRes val icon: Int,
    val nameApp: String,
    val description: String,
    val category: String
)
