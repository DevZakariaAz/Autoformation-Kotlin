package com.example.cartedevisite

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cartedevisite.ui.theme.CarteDeVisiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarteDeVisiteTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CarteDeVisite(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CarteDeVisite(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Name and Profession
        Text(
            text = "Zakaria Azizi",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Full Stack Developer",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))
        val context = LocalContext.current

        // Phone Contact
        val callIntent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:+212 634344178")
        }
        ContactInfo(
            label = "Téléphone :",
            value = "+212 634344178",
            onClick = { context.startActivity(callIntent) }
        )

        // Email Contact
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:Azizi.zakaria.solicode@gamil.com")
        }
        ContactInfo(
            label = "Email :",
            value = "Azizi.zakaria.solicode@gamil.com",
            onClick = { context.startActivity(emailIntent) }
        )

        // Location Contact
        val locationIntent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://maps.app.goo.gl/xWsTSyNEu1xQPTH46?g_st=ac")
        }
        ContactInfo(
            label = "Localisation :",
            value = "Maroc,Tanger",
            onClick = { context.startActivity(locationIntent) }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Website Button
        val websiteIntent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://devzakariaaz.github.io/Potfolio/")
        }
        Button(onClick = { context.startActivity(websiteIntent) }) {
            Text("Visiter mon Portfolio")
        }
    }
}

@Composable
fun ContactInfo(label: String, value: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(vertical = 4.dp)
    ) {
        Text(text = "$label ", fontWeight = FontWeight.Bold)
        Text(text = value, color = Color.Blue)
    }
}

@Preview(showBackground = true)
@Composable
fun CarteDeVisitePreview() {
    CarteDeVisiteTheme {
        CarteDeVisite()
    }
}
