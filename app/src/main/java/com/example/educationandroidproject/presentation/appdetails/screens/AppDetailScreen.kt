package com.example.educationandroidproject.presentation.appdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.data.SampleApps
import com.example.educationandroidproject.presentation.theme.EducationAndroidProjectTheme

@Composable
fun AppDetailScreen(
    appData: AppItem,
    modifier: Modifier = Modifier,
    onShowcaseAppClick: (AppItem) -> Unit = {}
) {
    Column(modifier = modifier) {
        InfoCardDetailScreen(appData.category, appData.nameApp, appData.icon)
        ButtonDownloadDetailScreen()
        ImageScrollPanelDetailScreen()
        DescriptionAppDetailScreen(appData.description)
        SeparetedDetailScreen()
        AppShowcase(
            apps = SampleApps.apps,
            onAppClick = onShowcaseAppClick)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppDetailScreen() {
    val apps = SampleApps.apps

    EducationAndroidProjectTheme() {
        AppDetailScreen(apps[1])
    }
}