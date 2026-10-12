package com.example.educationandroidproject.ui.uppdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.data.SampleApps
import com.example.educationandroidproject.ui.theme.EducationAndroidProjectTheme

@Composable
fun AppShowcase(
    onAppClick: (AppItem) -> Unit = {}
) {
    val pages = SampleApps.apps.chunked(3)
    val pagerState = rememberPagerState(pageCount = { pages.size })

    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Витрина",
            textAlign = TextAlign.Center
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            pageSpacing = 8.dp
        ) { page ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                pages[page].forEach { dataApp ->
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onAppClick(dataApp) },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AppShowcaseCard(appData = dataApp)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewAppShowcase() {
    EducationAndroidProjectTheme() {
        AppShowcase()
    }
}