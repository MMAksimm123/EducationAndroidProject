package com.example.educationandroidproject.domain.repository

import com.example.educationandroidproject.data.AppItem

interface AppRepository {
    suspend fun getApps(): List<AppItem>
    suspend fun getAppById(id: String): AppItem?
}