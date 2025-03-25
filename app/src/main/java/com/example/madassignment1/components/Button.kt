package com.example.madassignment1.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ButtonComponent(text: String, onClick: () -> Unit, modifier: Modifier = Modifier)
{
    Button(
        onClick = onClick,
        modifier = modifier.padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
    )
    {
        Text(text = text, color = Color.White, fontSize = 18.sp)
    }
}