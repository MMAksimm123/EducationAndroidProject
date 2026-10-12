package com.example.educationandroidproject.ui.uppdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.data.SampleApps
import com.example.educationandroidproject.ui.theme.EducationAndroidProjectTheme

@Composable
fun ListAppScreen(
    modifier: Modifier = Modifier,
    onAppClick: (AppItem) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        TopAppBarListAppScreen()
        SampleApps.apps.forEach { app ->
            AppCard(
                app = app,
                onClick = { onAppClick(app) }
            )
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