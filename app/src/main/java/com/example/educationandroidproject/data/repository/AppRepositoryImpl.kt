package com.example.educationandroidproject.data.repository

import com.example.educationandroidproject.R
import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.data.api.CatalogApi
import com.example.educationandroidproject.data.dto.AppDto
import com.example.educationandroidproject.data.mapper.toDomain
import com.example.educationandroidproject.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val api: CatalogApi
) : AppRepository {

    override suspend fun getApps(): List<AppItem> {
        return api.getCatalog().map { it.toDomain() }
    }

    override suspend fun getAppById(id: String): AppItem {
        return api.getAppById(id).toDomain()
    }
}