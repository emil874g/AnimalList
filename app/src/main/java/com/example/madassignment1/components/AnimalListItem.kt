package com.example.madassignment1.components

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.madassignment1.data.Animal
import com.example.madassignment1.activities.DetailActivity

@Composable
fun AnimalListItem(animal: Animal, onClick: () -> Unit){
    Text(
        text = animal.name,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(16.dp)
    )
}


