package com.example.educationandroidproject.data.repository

import com.example.educationandroidproject.R
import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.data.dto.AppDto
import com.example.educationandroidproject.data.mapper.toDomain
import com.example.educationandroidproject.domain.repository.AppRepository

class AppRepositoryImpl : AppRepository {
    private val mockBackendData = listOf(
        AppDto(
            1,
            R.drawable.dog,
            "Приложение 1",
            "Описание приложения 1",
            "Категория 1"
        ),
        AppDto(
            2,
            R.drawable.rabit,
            "Приложение 2",
            "Описание приложения 2",
            "Категория 2"
        ),
        AppDto(
            3,
            R.drawable.parrot,
            "Приложение 3",
            "Описание приложения 3",
            "Категория 3"
        ),
        AppDto(
            4,
            R.drawable.humster,
            "Приложение 4",
            "Описание приложения 4",
            "Категория 4"
        ),
        AppDto(
            5,
            R.drawable.dog,
            "Приложение 5",
            "Описание приложения 5",
            "Категория 5"
        ),
        AppDto(
            6,
            R.drawable.rabit,
            "Приложение 6",
            "Описание приложения 6",
            "Категория 6"
        ),
        AppDto(
            7,
            R.drawable.parrot,
            "Приложение 7",
            "Описание приложения 7",
            "Категория 7"
        ),
        AppDto(
            8,
            R.drawable.humster,
            "Приложение 8",
            "Описание приложения 8",
            "Категория 8"
        ),
        AppDto(
            9,
            R.drawable.dog,
            "Приложение 9",
            "Описание приложения 9",
            "Категория 9"
        ),
    )

    override fun getApps(): List<AppItem> {
        return mockBackendData.map { it.toDomain() }
    }

    override fun getAppById(id: Int): AppItem? {
        return getApps().find { it.id == id }
    }
}