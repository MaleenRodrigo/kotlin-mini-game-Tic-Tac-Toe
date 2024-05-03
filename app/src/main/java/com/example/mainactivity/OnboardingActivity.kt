package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        // Initialize views
        val startButton: Button = findViewById(R.id.startButton)

        // Set click listener for the start button
        startButton.setOnClickListener {
            // Start the game activity
            startActivity(Intent(this, MainActivity::class.java))
            // Finish this activity
            finish()
        }
    }
}
