package com.example.educationandroidproject

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.insert
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.then
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.educationandroidproject.ui.theme.EducationAndroidProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducationAndroidProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HoumworkModule(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun InputField(
    state: TextFieldState,
    modifier: Modifier = Modifier
) {
    TextField(
        state = state,
        label = {Text (text = "Введите номер телефона")},
        prefix = {Text("+7 ")},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone
        ),
        inputTransformation = InputTransformation.maxLength(10).then {
            if (!asCharSequence().isDigitsOnly()) {
                revertAllChanges()
            }
        },
        outputTransformation = OutputTransformation {
            if (length > 0) insert(0, "(")
            if (length > 4) insert(4, ") ")
            if (length > 9) insert(9, "-")
            if (length > 12) insert(12, "-")
        },
        modifier = modifier
    )
}

@Composable
fun HoumworkModule(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val textFieldState = rememberTextFieldState(initialText = "9999999999")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InputField(state = textFieldState)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            val text = textFieldState.text.toString()
            if (text.isBlank()) {
                Toast.makeText(context, "Введите текст", Toast.LENGTH_SHORT).show()
                return@Button
            }
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra("EXTRA_TEXT", text)
            }
            context.startActivity(intent)
        }) {
            Text(
                text = "Открыть вторую Activity"
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            val phone = textFieldState.text.toString()
            if (phone.isBlank()) {
                Toast.makeText(context, "Введите номер", Toast.LENGTH_SHORT).show()
                return@Button
            }
            callFriend(context, phone)
        }) {
            Text(text = "Позвонить другу")
        }
        Spacer(Modifier.height(8.dp))
        Button(onClick = {
            val text = textFieldState.text.toString()
            shareText(context, text)
        }) {
            Text(
                text = "Поделится текстом"
            )
        }
    }
}

fun callFriend(context: Context ,phoneNumber: String) {
    val implicitIntent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:+7$phoneNumber")
    }
    if (implicitIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(implicitIntent)
    }
}

fun shareText(context: Context, text: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, "Вот нужный номер телефона: +7$text")
    }
    context.startActivity(Intent.createChooser(intent, "Поделится через:") )
}

@Preview(showBackground = true)
@Composable
fun PreviewHoumworkModule() {
    val textFieldState = rememberTextFieldState(initialText = "9999999999")
    InputField(state = textFieldState)
}