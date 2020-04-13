package com.example.baseuisample.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.baseuisample.R

class MainActivity : AppCompatActivity() {

    private lateinit var nextScreenBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initListeners()
    }

    private fun initViews() {
        nextScreenBtn = findViewById(R.id.open_second_screen_btn)
    }

    private fun initListeners() {
        nextScreenBtn.setOnClickListener { openSecondActivity() }
    }

    private fun openSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}
