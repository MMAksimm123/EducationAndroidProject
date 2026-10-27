package com.example.educationandroidproject.domain.repository

import com.example.educationandroidproject.data.AppItem

interface AppRepository {
    fun getApps(): List<AppItem>
    fun getAppById(id: Int): AppItem?
}