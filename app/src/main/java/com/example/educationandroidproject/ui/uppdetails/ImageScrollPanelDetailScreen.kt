package com.example.educationandroidproject.ui.uppdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.educationandroidproject.R
import com.example.educationandroidproject.ui.theme.EducationAndroidProjectTheme

@Composable
fun ImageScrollPanelDetailScreen() {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = stringResource(R.string.screenshot),
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 15.sp
        )
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.cat1),
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Image(
                painter = painterResource(R.drawable.cat2),
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Image(
                painter = painterResource(R.drawable.cat3),
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewImageScrollPanelDetailScreen() {
    EducationAndroidProjectTheme() {
        ImageScrollPanelDetailScreen()
    }
}