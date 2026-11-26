package com.example.educationandroidproject.data.mapper

import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.data.dto.AppDto
import com.example.educationandroidproject.data.local.AppDetailsEntity
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

    fun mapEntityToDomain(entity: AppDetailsEntity): AppItem {
        return AppItem(
            id = entity.id,
            iconUrl = entity.iconUrl,
            nameApp = entity.nameApp,
            description = entity.description,
            category = entity.category,
            isInWishlist = entity.isInWishlist
        )
    }

    fun mapDomainToEntity(domain: AppItem): AppDetailsEntity {
        return AppDetailsEntity(
            id = domain.id,
            iconUrl = domain.iconUrl,
            nameApp = domain.nameApp,
            description = domain.description,
            category = domain.category,
            isInWishlist = domain.isInWishlist
        )
    }
}