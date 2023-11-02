package com.example.kurumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener { onLogin() }

        val tvRegistro = findViewById<TextView>(R.id.tvRegistro)
        tvRegistro.setOnClickListener { onRegistro() }
    }

    private fun onLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun onRegistro() {
        val intent = Intent(this, RegistroActivity::class.java)
        startActivity(intent)
    }
}