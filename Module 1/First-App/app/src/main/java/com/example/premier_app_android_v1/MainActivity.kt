package com.example.premier_app_android_v1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.premier_app_android_v1.ui.theme.Premier_App_Android_v1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Premier_App_Android_v1Theme {
                Greeting(name = "Zakaria")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name! Welcome to My first Android app!")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Premier_App_Android_v1Theme {
        Greeting("Zakaria")
    }
}
