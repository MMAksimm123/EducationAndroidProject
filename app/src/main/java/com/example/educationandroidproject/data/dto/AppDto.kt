package com.example.educationandroidproject.data.dto

import androidx.annotation.DrawableRes

data class AppDto(
    val id: Int,
    @DrawableRes val iconRes: Int,
    val title: String,
    val desc: String,
    val type: String
)