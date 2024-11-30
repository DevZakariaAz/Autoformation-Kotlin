package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorApp()
        }
    }
}

@Composable
fun TipCalculatorApp() {
    // State for amount and tip percentage
    var amountInput by remember { mutableStateOf("") }
    // 15f is used to represent a tip percentage of 15% as a floating-point value
    var tipPercentage by remember { mutableStateOf(15f) }

    // Calculate tip and total
    val amount = amountInput.toFloatOrNull() ?: 0f
    val tipAmount = amount * tipPercentage / 100
    val totalAmount = amount + tipAmount

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input field for the bill amount
        TextField(
            value = amountInput,
            onValueChange = { amountInput = it },
            label = { Text("Montant de l'addition") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Slider to select tip percentage
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Pourcentage : ${tipPercentage.toInt()}%")
            Slider(
                value = tipPercentage,
                onValueChange = { tipPercentage = it },
                valueRange = 0f..30f,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Display the calculated tip and total
        Text("Pourboire : %.2f MAD".format(tipAmount))
        Text("Total : %.2f MAD".format(totalAmount))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TipCalculatorApp()
}
