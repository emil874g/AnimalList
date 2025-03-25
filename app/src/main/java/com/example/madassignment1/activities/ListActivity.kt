package com.example.madassignment1.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.madassignment1.components.TopBar
import com.example.madassignment1.data.Animal
import com.example.madassignment1.data.Repository
import com.example.madassignment1.activities.DetailActivity
import com.example.madassignment1.components.AnimalListItem

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListScreen()
        }
    }

    @Composable
    fun ListScreen() {
        val animals = Repository.AnimalList

        Scaffold(
            topBar = { TopBar(title = "Animal List", onBackClick = { finish() }) },
        ) { innerPadding ->
            LazyColumn(modifier = Modifier.padding(innerPadding)) {
                items(animals) { animal ->
                    AnimalListItem(animal = animal, onClick = {
                        val intent = Intent(this@ListActivity, DetailActivity::class.java)
                        intent.putExtra("animalName", animal.name)
                        startActivity(intent)
                    })
                }
            }
        }
    }
}

