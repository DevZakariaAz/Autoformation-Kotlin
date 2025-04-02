package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationApp()
        }
    }
}

// Liste des affirmations statiques
val affirmations = mutableListOf(
    "Chaque jour est une nouvelle opportunité.",
    "Tu es plus fort que tu ne le penses.",
    "Le succès commence par la volonté de l'atteindre."
)

@Composable
fun AffirmationApp() {
    var newAffirmation by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current

    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(16.dp)) {
                AffirmationList(affirmations) { affirmation ->
                    Toast.makeText(context, "Vous avez cliqué sur : $affirmation", Toast.LENGTH_SHORT).show()
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column {
                    Text(text = "Nouvelle affirmation :", style = MaterialTheme.typography.bodyLarge)
                    BasicTextField(
                        value = newAffirmation,
                        onValueChange = { newAffirmation = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .border(1.dp, Color.Gray)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    if (newAffirmation.text.isNotBlank()) {
                        affirmations.add(newAffirmation.text)
                        newAffirmation = TextFieldValue("")
                    }
                }) {
                    Text("Ajouter")
                }
            }
        }
    }
}

@Composable
fun AffirmationList(affirmations: List<String>, onItemClicked: (String) -> Unit) {
    LazyColumn {
        items(affirmations) { affirmation ->
            AffirmationCard(affirmation, onClick = { onItemClicked(affirmation) })
        }
    }
}

@Composable
fun AffirmationCard(affirmation: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Text(
            text = affirmation,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
            modifier = Modifier.padding(16.dp)
        )
    }
}
