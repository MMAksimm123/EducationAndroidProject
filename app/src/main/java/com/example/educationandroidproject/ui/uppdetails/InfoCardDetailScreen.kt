package com.example.educationandroidproject.ui.uppdetails

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.educationandroidproject.R
import com.example.educationandroidproject.ui.theme.EducationAndroidProjectTheme

@Composable
fun InfoCardDetailScreen(category: String, name: String, iconApp: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(iconApp),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .padding(8.dp)
                .clip(RoundedCornerShape(15.dp))
        )
        Column() {
            Text(
                text = category,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 10.sp
            )
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = stringResource(R.string.autor_app_1),
                fontSize = 10.sp
            )
            Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(R.string.age_app_1),
                        fontSize = 15.sp
                    )
                    Text(
                        text = stringResource(R.string.age),
                        fontSize = 15.sp
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = stringResource(R.string.size_app_1),
                        fontSize = 15.sp
                    )
                    Text(
                        text = stringResource(R.string.size),
                        fontSize = 15.sp
                    )
                }
                
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInfoCardDetailScreen() {
    EducationAndroidProjectTheme() {
        InfoCardDetailScreen(name = "Test", category = "TestCategory", iconApp = 1)
    }
}