package com.example.educationandroidproject.presentation.appdetails

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SeparetedDetailScreen() {
    HorizontalDivider(
        modifier = Modifier.padding(5.dp),
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.secondary
    )
}