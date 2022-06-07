package com.example.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var handler: Handler
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        //splash screen 3s
        handler= Handler()
        handler.postDelayed({
            val intent= Intent(this,login::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}