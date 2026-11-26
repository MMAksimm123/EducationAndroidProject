package com.example.educationandroidproject.data.repository

import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.data.api.CatalogApi
import com.example.educationandroidproject.data.local.AppDetailsDao
import com.example.educationandroidproject.data.mapper.AppMapper
import com.example.educationandroidproject.domain.repository.AppDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDetailsRepositoryImpl @Inject constructor(
    private val api: CatalogApi,
    private val dao: AppDetailsDao,
    private val mapper: AppMapper
) : AppDetailsRepository {
    override suspend fun fetchAndSaveAppDetails(id: String) {
        val dto = api.getAppById(id)
        val domain = mapper.mapToDomain(dto)

        val existingEntity = dao.getAppDetailsOnce(id)

        val newEntity = mapper.mapDomainToEntity(domain).copy(
            isInWishlist = existingEntity?.isInWishlist ?: false
        )
        dao.insertAppDetails(newEntity)
    }

    override fun observeAppDetails(id: String): Flow<AppItem> {
        return dao.getAppDetails(id).map { entity ->
            mapper.mapEntityToDomain(entity)
        }
    }

    override suspend fun toggleWishlist(id: String) {
        val currentEntity = dao.getAppDetails(id).first()
        dao.updateWishlistStatus(id, !currentEntity.isInWishlist)
    }
}