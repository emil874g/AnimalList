package com.example.madassignment1.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.madassignment1.components.AnimalListItem
import com.example.madassignment1.components.TopBar
import com.example.madassignment1.data.Repository

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListScreen()
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun ListScreen() {
        val animals = Repository.AnimalList

        Scaffold(
            topBar = { TopBar(title = "Animal List") },
            content = {
                LazyColumn {
                    items(animals) { animal ->
                        AnimalListItem(animal, this@ListActivity)
                    }
                }
            }
        )
    }
}
