package com.example.educationandroidproject.presentation.appdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.educationandroidproject.R
import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.presentation.appdetails.viewModel.DetailViewModel
import com.example.educationandroidproject.presentation.theme.EducationAndroidProjectTheme

@Composable
fun AppDetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    onShowcaseAppClick: (AppItem) -> Unit = {}
) {
    val appData = viewModel.appData
    val showcaseApps = viewModel.showcaseApps

    if (appData != null) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            InfoCardDetailScreen(appData.category, appData.nameApp, appData.icon)
            ButtonDownloadDetailScreen()
            ImageScrollPanelDetailScreen()
            DescriptionAppDetailScreen(appData.description)
            SeparetedDetailScreen()
            AppShowcase(
                apps = showcaseApps,
                onAppClick = onShowcaseAppClick)
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = stringResource(R.string.error_message),
                tint = MaterialTheme.colorScheme.error,
                modifier = Modifier.size(48.dp)
            )
            Spacer(
                modifier = Modifier.height(24.dp)
            )
            Text(
                text = stringResource(R.string.error_message),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppDetailScreen() {
    EducationAndroidProjectTheme() {
        AppDetailScreen()
    }
}