package com.example.practice10

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn1: Button = findViewById(R.id.button1)
        val btn2: Button = findViewById(R.id.button2)
        var isBtn1Visible = true

        btn1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (isBtn1Visible) {
                    btn1.visibility = View.INVISIBLE
                    btn2.visibility = View.VISIBLE
                    isBtn1Visible = false
                }
            }
        })

        btn2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if (!isBtn1Visible) {
                    btn2.visibility = View.INVISIBLE
                    btn1.visibility = View.VISIBLE
                    isBtn1Visible = true
                }
            }
        })

    }
}