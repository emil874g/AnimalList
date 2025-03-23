package com.example.madassignment1.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.madassignment1.components.TopBar
import kotlinx.coroutines.launch

class FrontActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FrontScreen()
        }
    }

    @Composable
    fun FrontScreen() {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    TextButton(onClick = {
                        startActivity(Intent(this@FrontActivity, ListActivity::class.java))
                    }) {
                        Text("Animal List")
                    }
                }
            }
        ) {
            Scaffold(
                topBar = { TopBar(title = "Main Menu") },
                content = { paddingValues ->
                    Button(
                        onClick = { scope.launch { drawerState.open() } },
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        Text("Open Menu")
                    }
                }
            )
        }
    }
}
