package com.example.educationandroidproject.ui.uppdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.educationandroidproject.ui.theme.EducationAndroidProjectTheme

@Composable
fun AppDetailScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        InfoCardDetailScreen()
        ButtonDownloadDetailScreen()
        ImageScrollPanelDetailScreen()
        DescriptionAppDetailScreen()
        SeparetedDetailScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppDetailScreen() {
    EducationAndroidProjectTheme() {
        AppDetailScreen()
    }
}