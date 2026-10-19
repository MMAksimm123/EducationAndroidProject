package com.example.educationandroidproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.educationandroidproject.navigation.AppNavHost
import com.example.educationandroidproject.ui.theme.EducationAndroidProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EducationAndroidProjectTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    AppNavHost()
                }
            }
        }
    }
}