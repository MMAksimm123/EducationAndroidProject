package com.example.educationandroidproject.presentation.appdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.educationandroidproject.R
import com.example.educationandroidproject.presentation.theme.EducationAndroidProjectTheme

@Composable
fun TopAppBarDetailScreen() {
    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .windowInsetsPadding(WindowInsets.statusBars)) {
        IconButton(
            onClick = {}
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_back_24dp_1f1f1f_fill0_wght400_grad0_opsz24),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = {}
        ) {
            Icon(
                painter = painterResource(R.drawable.share_24dp_1f1f1f_fill0_wght400_grad0_opsz24),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppBarState() {
    EducationAndroidProjectTheme() {
        TopAppBarDetailScreen()
    }
}