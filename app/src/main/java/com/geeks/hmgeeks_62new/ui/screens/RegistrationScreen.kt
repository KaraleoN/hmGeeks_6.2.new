package com.geeks.hmgeeks_62new.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun RegistrationScreen(onRegister: (String) -> Unit) {
    var username by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }

    LaunchedEffect(username) {
        isButtonEnabled = username.isNotBlank()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Registration Screen")
        BasicTextField(
            value = username,
            onValueChange = { username = it },
            decorationBox = { innerTextField ->
                if (username.isEmpty()) {
                    Text("Enter your name", color = androidx.compose.ui.graphics.Color.Gray)
                }
                innerTextField()
            }
        )
        Button(
            onClick = { onRegister(username) },
            enabled = isButtonEnabled
        ) {
            Text(text = "Register")
        }
    }
}