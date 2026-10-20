package com.example.educationandroidproject.presentation.appdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educationandroidproject.R
import com.example.educationandroidproject.presentation.theme.EducationAndroidProjectTheme

@Composable
fun TopAppBarListAppScreen(
    onLogoClick: () -> Unit = {}
) {
    Row (modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.primary)
            .padding(vertical = 5.dp)
            .clickable { onLogoClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.app_badging),
            contentDescription = stringResource(R.string.store_name),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .padding(5.dp)
                .clip(RoundedCornerShape(5.dp))
        )
        Text(
            text = stringResource(R.string.store_name),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTopAppBarListAppScreen() {
    EducationAndroidProjectTheme() {
        TopAppBarListAppScreen()
    }
}