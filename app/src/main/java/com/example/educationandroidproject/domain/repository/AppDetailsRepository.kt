package com.example.educationandroidproject.domain.repository

import com.example.educationandroidproject.data.AppItem
import kotlinx.coroutines.flow.Flow

interface AppDetailsRepository {
    suspend fun fetchAndSaveAppDetails(id: String)

    fun observeAppDetails(id: String): Flow<AppItem>

    suspend fun toggleWishlist(id: String)
}