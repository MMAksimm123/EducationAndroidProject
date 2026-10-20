package com.example.educationandroidproject.presentation.appdetails

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.educationandroidproject.R
import com.example.educationandroidproject.presentation.theme.EducationAndroidProjectTheme

@Composable
fun DescriptionAppDetailScreen(description: String) {
    val minimizedMaxLines: Int = 2
    var isExpanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()) {
        Text(
            text = stringResource(R.string.description),
            fontSize = 15.sp
        )
        Text(
            text = description,
            maxLines = if (isExpanded) Int.MAX_VALUE else minimizedMaxLines,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.animateContentSize()
        )
        Text(
            text = if (isExpanded) stringResource(R.string.roll_up) else stringResource(R.string.more),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(top = 5.dp)
                .clickable { isExpanded = !isExpanded }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDescriptionAppDetailScreen() {
    EducationAndroidProjectTheme() {
        DescriptionAppDetailScreen(description = "Test")
    }
}