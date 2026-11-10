package com.example.educationandroidproject.presentation.appdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.educationandroidproject.R
import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.presentation.appdetails.viewModel.AppDetailsState
import com.example.educationandroidproject.presentation.appdetails.viewModel.DetailViewModel
import com.example.educationandroidproject.presentation.theme.EducationAndroidProjectTheme

@Composable
fun AppDetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    onShowcaseAppClick: (AppItem) -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val currentState = state) {
        is AppDetailsState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is AppDetailsState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = currentState.message,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        is AppDetailsState.Content -> {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                InfoCardDetailScreen(
                    category = currentState.app.category,
                    name = currentState.app.nameApp,
                    iconApp = currentState.app.iconUrl
                )
                ButtonDownloadDetailScreen(
                    installState = currentState.installState,
                    onInstallClick = viewModel::onInstallClick
                )
                ImageScrollPanelDetailScreen()
                DescriptionAppDetailScreen(currentState.app.description)
                SeparetedDetailScreen()
                AppShowcase(
                    apps = currentState.showcaseApps,
                    onAppClick = onShowcaseAppClick
                )
            }
        }
    }
//    if (errorMessage != null) {
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            Text(text = errorMessage!!, modifier = Modifier.padding(16.dp))
//        }
//        return
//    }
//
//    if (appData == null) {
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//            CircularProgressIndicator()
//        }
//        return
//    }
//
//    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
//        InfoCardDetailScreen(appData!!.category, appData!!.nameApp, appData!!.iconUrl)
//        ButtonDownloadDetailScreen()
//        ImageScrollPanelDetailScreen()
//        DescriptionAppDetailScreen(appData!!.description)
//        SeparetedDetailScreen()
//
//        AppShowcase(
//            apps = showcaseApps,
//            onAppClick = onShowcaseAppClick
//        )
//    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppDetailScreen() {
    EducationAndroidProjectTheme() {
        AppDetailScreen()
    }
}