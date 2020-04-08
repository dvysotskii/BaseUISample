package com.example.baseuisample.view

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.example.baseuisample.R
import kotlinx.android.synthetic.main.view_custom.view.*

class CustomView @JvmOverloads constructor(context: Context, attr: AttributeSet? = null)
    : LinearLayout(context, attr) {

    init {
        orientation = VERTICAL
        gravity = Gravity.CENTER

        View.inflate(context, R.layout.view_custom, this)
        first_btn.setOnClickListener { performClick() }
    }
}