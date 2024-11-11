package com.geeks.hmgeeks_62new.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ConfirmationScreen(username: String?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Confirmation Screen")
        if (!username.isNullOrEmpty()) {
            Text(text = "Welcome, $username!")
        } else {
            Text(text = "No username provided!")
        }
    }
}