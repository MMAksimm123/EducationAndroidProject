package com.example.educationandroidproject.data.repository

import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.data.api.CatalogApi
import com.example.educationandroidproject.data.mapper.AppMapper
import com.example.educationandroidproject.domain.repository.AppRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor(
    private val api: CatalogApi,
    private val mapper: AppMapper
) : AppRepository {

    override suspend fun getApps(): List<AppItem> {
        return mapper.mapToDomainList(api.getCatalog())
    }

    override suspend fun getAppById(id: String): AppItem {
        return mapper.mapToDomain(api.getAppById(id))
    }
}