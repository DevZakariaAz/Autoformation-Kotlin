package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppScreen()
        }
    }
}

@Composable
fun MyAppScreen() {
    var inputText by remember { mutableStateOf("") }
    val items = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Text Input
        BasicTextField(
            value = inputText,
            onValueChange = { inputText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                // Label for the TextField
                Text(text = "Enter text:", style = MaterialTheme.typography.bodyLarge)

                // TextField content
                it()
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Button to Add Items
        Button(
            onClick = {
                if (inputText.isNotBlank()) {
                    items.add(inputText)
                    inputText = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add to List")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // List of Items
        LazyColumn {
            items(items.size) { index ->
                Text(
                    text = items[index],
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyAppScreen() {
    MyAppScreen()
}
