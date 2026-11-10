package com.example.educationandroidproject.data.mapper

import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.data.dto.AppDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppMapper @Inject constructor() {
    fun mapToDomain(dto: AppDto): AppItem {
        return AppItem(
            id = dto.id,
            iconUrl = dto.iconUrl,
            nameApp = dto.name,
            description = dto.description,
            category = dto.category
        )
    }

    fun mapToDomainList(dtos: List<AppDto>): List<AppItem> {
        return dtos.map {
            mapToDomain(it)
        }
    }
}