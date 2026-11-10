package com.example.educationandroidproject.presentation.appdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educationandroidproject.R
import com.example.educationandroidproject.presentation.appdetails.viewModel.InstallState
import com.example.educationandroidproject.presentation.theme.EducationAndroidProjectTheme

@Composable
fun ButtonDownloadDetailScreen(
    installState: InstallState,
    onInstallClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onInstallClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            when (installState) {
                is InstallState.NotInstalled -> {
                    Text(
                        text = stringResource(R.string.download)
                    )
                }
                is InstallState.Installing -> {
                    Text(
                        text = ("Отменить (${installState.progress}%)")
                    )
                }
                is InstallState.Installed -> {
                    Text(stringResource(R.string.installed))
                }
            }
        }

        if (installState is InstallState.Installing) {
            Spacer(modifier = Modifier.height(8.dp))
            LinearProgressIndicator(
                progress = { installState.progress / 100f },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

//@Preview
//@Composable
//fun PreviewButtonDownloadDetailScreen() {
//    EducationAndroidProjectTheme() {
//        ButtonDownloadDetailScreen()
//    }
//}
