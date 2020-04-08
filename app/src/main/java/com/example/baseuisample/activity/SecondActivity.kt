package com.example.baseuisample.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.baseuisample.R
import com.example.baseuisample.fragment.FirstFragment


private const val FIRST_FRAGMET_TAG = "123"

class SecondActivity : AppCompatActivity() {

    private lateinit var showFirstFragmentBtn: Button
    private lateinit var removeFirstFragmentBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        showFirstFragmentBtn = findViewById(R.id.show_fragment_btn)
        showFirstFragmentBtn.setOnClickListener {
            showFirstFragment()
        }
        removeFirstFragmentBtn = findViewById(R.id.remove_fragment_btn)
        removeFirstFragmentBtn.setOnClickListener {
            removeFirstFragment()
        }
    }

    private fun showFirstFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, FirstFragment.newInstance(), FIRST_FRAGMET_TAG)
            .commit()
    }

    private fun removeFirstFragment() {
        val firstFragment = supportFragmentManager.findFragmentByTag(FIRST_FRAGMET_TAG)

        firstFragment?.let {
            supportFragmentManager
                .beginTransaction()
                .remove(firstFragment)
                .commit()
        }
    }
}
