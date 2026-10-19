package com.example.educationandroidproject.ui.uppdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.data.SampleApps
import com.example.educationandroidproject.ui.theme.EducationAndroidProjectTheme

@Composable
fun ListAppScreen(
    apps: List<AppItem>,
    modifier: Modifier = Modifier,
    onAppClick: (AppItem) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        TopAppBarListAppScreen()
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(apps) { app ->
                AppCard(
                    app = app,
                    onClick = {onAppClick(app)}
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewListAppScreen() {
    EducationAndroidProjectTheme() {
        ListAppScreen(apps = SampleApps.apps)
    }
}