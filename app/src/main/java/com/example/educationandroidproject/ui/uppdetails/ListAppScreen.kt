package com.example.educationandroidproject.ui.uppdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educationandroidproject.R
import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.ui.theme.EducationAndroidProjectTheme

@Composable
fun ListAppScreen(modifier: Modifier = Modifier) {
    val apps = listOf(
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
        AppItem(
            R.drawable.parrot,
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
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        TopAppBarListAppScreen()
        apps.forEach { app ->
            AppCard(app = app)
        }
    }
}

@Preview
@Composable
fun PreviewListAppScreen() {
    EducationAndroidProjectTheme() {
        ListAppScreen()
    }
}