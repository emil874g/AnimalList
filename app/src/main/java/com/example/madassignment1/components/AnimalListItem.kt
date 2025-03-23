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
fun AnimalListItem(animals: Animal, context: Context) {
    Row (
        modifier = Modifier.fillMaxSize().clickable {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("animal", animals.name)
                context.startActivity(intent)
        }
            .padding(16.dp)
    ) {
        Text(text = animals.name, style = MaterialTheme.typography.bodySmall)
    }
}