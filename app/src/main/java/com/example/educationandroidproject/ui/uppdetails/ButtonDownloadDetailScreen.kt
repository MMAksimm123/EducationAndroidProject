package com.example.educationandroidproject.ui.uppdetails

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educationandroidproject.R
import com.example.educationandroidproject.ui.theme.EducationAndroidProjectTheme

@Composable
fun ButtonDownloadDetailScreen() {
    Button(
        onClick = {},
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(contentColor = MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(
            text = stringResource(R.string.download),
            color = MaterialTheme.colorScheme.background
        )
    }
}

@Preview
@Composable
fun PreviewButtonDownloadDetailScreen() {
    EducationAndroidProjectTheme() {
        ButtonDownloadDetailScreen()
    }
}
