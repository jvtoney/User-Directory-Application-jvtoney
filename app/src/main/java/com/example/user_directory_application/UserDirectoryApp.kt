package com.example.user_directory_application

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.user_directory_application.UserListScreen

@Composable
fun UserDirectoryApp() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            UserListScreen()
        }
    }
}