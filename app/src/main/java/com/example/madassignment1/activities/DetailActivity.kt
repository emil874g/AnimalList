package com.example.madassignment1.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.madassignment1.components.TopBar
import com.example.madassignment1.data.Repository


class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val animalName = intent.getStringExtra("animalName")
        val animal = Repository.AnimalList.find { it.name == animalName }

        setContent {
            DetailScreen(animal)
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun DetailScreen(animal: com.example.madassignment1.data.Animal?) {
        Scaffold(
            topBar = { TopBar(title = "Animal Details") },
            content = {
                if (animal != null) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(text = "Name: ${animal.name}", style = MaterialTheme.typography.displaySmall)
                        Text(text = "Species: ${animal.species}")
                        Text(text = "Color: ${animal.color}")
                        Text(text = "Type: ${animal.type}")
                        Spacer(modifier = Modifier.height(20.dp))

                        Button(onClick = { finish() }) {
                            Text("Back")
                        }
                    }
                } else {
                    Text(text = "Animal not found", modifier = Modifier.padding(16.dp))
                }
            }
        )
    }
}
