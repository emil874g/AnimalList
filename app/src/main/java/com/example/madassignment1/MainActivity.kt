package com.example.madassignment1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.madassignment1.activities.FrontActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Start the main menu (FrontActivity)
        val intent = Intent(this, FrontActivity::class.java)
        startActivity(intent)

        // Finish this activity so it doesn’t stay in the back stack
        finish()
    }
}



