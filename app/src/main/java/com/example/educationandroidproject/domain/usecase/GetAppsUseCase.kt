package com.example.educationandroidproject.domain.usecase

import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.domain.repository.AppRepository
import javax.inject.Inject

class GetAppsUseCase @Inject constructor(
    private val repository: AppRepository
) {
    suspend operator fun invoke(): List<AppItem> {
        return repository.getApps()
    }
}