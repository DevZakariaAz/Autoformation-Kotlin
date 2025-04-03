package com.example.lab_view_model

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab_view_model.models.RetrofitClient
import com.example.lab_view_model.models.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoScreen()
        }
    }
}

@Composable
fun TodoScreen() {
    var title by remember { mutableStateOf("Chargement...") }

    LaunchedEffect(Unit) {
        try {
            // Appel API dans un thread IO
            val response: Response<Todo> = withContext(Dispatchers.IO) {
                RetrofitClient.api.getTodo().execute()
            }

            if (response.isSuccessful) {
                title = response.body()?.title ?: "Aucune donnée"
            } else {
                title = "Erreur HTTP ${response.code()}"
            }
        } catch (e: Exception) {
            title = "Erreur : ${e.message}"
        }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
        }
    }
}

