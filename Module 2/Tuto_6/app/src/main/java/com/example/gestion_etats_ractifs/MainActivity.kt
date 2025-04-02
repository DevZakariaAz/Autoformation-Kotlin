package com.example.gestion_etats_ractifs

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

// Step 1: Reactive State (Counter)
@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Count: $count", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { count++ }) {
            Text("Increment") 
        }
    }
}

// Step 2: Coroutines (Async Data Loader)
@Composable
fun AsyncDataLoader() {
    var data by remember { mutableStateOf("Loading...") }

    // Launch the coroutine to fetch data
    LaunchedEffect(Unit) {
        data = fetchData()
    }

    Text(
        text = data,
        style = MaterialTheme.typography.bodyLarge
    )
}

suspend fun fetchData(): String {
    delay(2000) // Simulate a loading delay of 2 seconds
    return "Data Loaded"
}

// Step 3: Flow (Data Stream)
@Composable
fun DataStream() {
    // Create a flow that emits data
    val dataFlow = flow {
        for (i in 1..5) {
            emit("Item $i")  // Emit each item
            delay(1000) // Simulate delay between items
        }
    }

    // Collect the flow's data and display it
    val data by dataFlow.collectAsState(initial = "Starting...")

    Text(text = data, style = MaterialTheme.typography.bodyLarge)
}

// Full App: Combine everything in one screen
@Composable
fun App() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Counter()  // Show the counter
        Spacer(modifier = Modifier.height(32.dp))
        AsyncDataLoader()  // Show the async data loader
        Spacer(modifier = Modifier.height(32.dp))
        DataStream()  // Show the data stream
    }
}

// Preview to see everything in the UI
@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    MaterialTheme {
        App()  // Preview the app
    }
}
