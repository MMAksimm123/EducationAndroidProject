package com.example.educationandroidproject.data

import com.example.educationandroidproject.R

object SampleApps {
    val apps: List<AppItem> = listOf(
        AppItem(
            R.drawable.dog,
            "Приложение 1",
            "Описание приложения 1",
            "Категория 1"
        ),
        AppItem(
            R.drawable.rabit,
            "Приложение 2",
            "Описание приложения 2",
            "Категория 2"
        ),
        AppItem(
            R.drawable.parrot,
            "Приложение 3",
            "Описание приложения 3",
            "Категория 3"
        ),
        AppItem(
            R.drawable.humster,
            "Приложение 4",
            "Описание приложения 4",
            "Категория 4"
        ),
        AppItem(
            R.drawable.dog,
            "Приложение 5",
            "Описание приложения 5",
            "Категория 5"
        ),
        AppItem(
            R.drawable.rabit,
            "Приложение 6",
            "Описание приложения 6",
            "Категория 6"
        ),
        AppItem(R.drawable.parrot,
            "Приложение 7",
            "Описание приложения 7",
            "Категория 7"
        ),
        AppItem(
            R.drawable.humster,
            "Приложение 8",
            "Описание приложения 8",
            "Категория 8"
        ),
        AppItem(
            R.drawable.dog,
            "Приложение 9",
            "Описание приложения 9",
            "Категория 9"
        ),
    )
    fun byIndex(index: Int): AppItem = apps[index]
}