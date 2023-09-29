package com.example.mynewapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonClick: Button = findViewById(R.id.button)
        buttonClick.setOnClickListener {
            val toast = Toast.makeText(this,"The button is pressed",Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}