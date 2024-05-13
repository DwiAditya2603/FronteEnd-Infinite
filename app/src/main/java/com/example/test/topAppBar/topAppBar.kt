package com.example.test.topAppBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBar(
    text : String
){
    TopAppBar(title = {
        Text(
            text = text,
            color = Color.Yellow,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Normal
        )
    },colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Gray))
}
