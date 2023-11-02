package com.example.kurumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //val btnIniciarSesion = findViewById<Button>(R.id.btnIniciarSesion)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro)

        btnRegistro.setOnClickListener { onRegistro() }
    }

    private fun onRegistro() {
        val intent = Intent(this, RegistroActivity::class.java)
        startActivity(intent)
    }
}