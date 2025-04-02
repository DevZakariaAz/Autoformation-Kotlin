package com.example.lab_view_model

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab_view_model.models.RetrofitClient
import com.example.lab_view_model.models.Todo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListScreen()
        }
    }
}

@Composable
fun TodoListScreen() {
    var todos by remember { mutableStateOf<List<Todo>>(emptyList()) }
    var errorMessage by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        val call = RetrofitClient.api.getTodos()
        call.enqueue(object : Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                if (response.isSuccessful) {
                    todos = response.body() ?: emptyList()
                } else {
                    errorMessage = "Erreur HTTP : ${response.code()}"
                }
            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                errorMessage = "Erreur réseau : ${t.message}"
            }
        })
    }

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(modifier = Modifier.padding(16.dp)) {
            if (errorMessage.isNotEmpty()) {
                Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
            } else {
                LazyColumn {
                    items(todos) { todo ->
                        TodoItem(todo)
                    }
                }
            }
        }
    }
}

@Composable
fun TodoItem(todo: Todo) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp), elevation = CardDefaults.cardElevation(4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "ID: ${todo.id}", style = MaterialTheme.typography.bodySmall)
            Text(text = todo.title, style = MaterialTheme.typography.bodyLarge)
            Text(
                text = if (todo.completed) "✅ Completed" else "❌ Not Completed",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
