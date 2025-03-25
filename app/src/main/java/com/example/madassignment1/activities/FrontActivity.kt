package com.example.madassignment1.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.madassignment1.components.ButtonComponent
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
            drawerContent = {
                TextButton(onClick = {startActivity(Intent(this@FrontActivity,
                    ListActivity::class.java))
                }) {Text("Animal List")}
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Menu",
                        fontSize = 24.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Button( // WHY IS THIS BUTTON THE WAY IT IS?
                        onClick = {startActivity(Intent(this@FrontActivity, ListActivity::class.java)) },
                        modifier = Modifier.fillMaxWidth())
                        {Text("Animal List", fontSize = 18.sp)}
                }
            },
            drawerState = drawerState
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = { TopBar(title = "Main Menu") }
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ButtonComponent(onClick = { scope.launch { drawerState.open() } }, text = "Open Menu")
                }
            }
        }
    }
}
