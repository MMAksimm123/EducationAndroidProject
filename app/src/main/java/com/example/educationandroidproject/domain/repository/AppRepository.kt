package com.example.educationandroidproject.domain.repository

import com.example.educationandroidproject.data.AppItem

interface AppRepository {
    suspend fun getApps(): List<AppItem>
    suspend fun getAppById(id: String): AppItem?

    suspend fun loadRatingsSequentially(ids: List<String>): Map<String, Float>
    suspend fun loadRatingsInParallel(ids: List<String>): Map<String, Float>
}