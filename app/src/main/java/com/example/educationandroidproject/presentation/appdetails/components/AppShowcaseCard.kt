package com.example.educationandroidproject.presentation.appdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educationandroidproject.R
import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.data.SampleApps
import com.example.educationandroidproject.presentation.theme.EducationAndroidProjectTheme

@Composable
fun AppShowcaseCard(appData: AppItem) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(5.dp)
        ) {
            Image(
                painter = painterResource(appData.icon),
                contentDescription = appData.nameApp,
                modifier = Modifier
                    .size(80.dp)
                    .padding(5.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Text(
                text = appData.nameApp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            ) {
                Text(
                    text = stringResource(R.string.download_2),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewAppShpwcaseCard() {
    val apps = SampleApps.apps
    EducationAndroidProjectTheme() {
        AppShowcaseCard(apps[0])
    }
}