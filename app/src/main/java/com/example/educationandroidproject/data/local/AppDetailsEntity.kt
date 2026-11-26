package com.example.educationandroidproject.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_details")
data class AppDetailsEntity(
    @PrimaryKey val id: String,
    val iconUrl: String,
    val nameApp: String,
    val description: String,
    val category: String,
    val isInWishlist: Boolean = false
)