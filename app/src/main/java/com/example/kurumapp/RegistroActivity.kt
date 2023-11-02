package com.example.kurumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistroActivity : AppCompatActivity() {

    private lateinit var etPassword: EditText
    private lateinit var etPasswordC: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        initComponents()
        //val etNombre = findViewById<EditText>(R.id.etNombre)
        //val etEmail = findViewById<EditText>(R.id.etEmail)
        val btnIniciarSesion = findViewById<Button>(R.id.btnIniciarSesion)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro)

        btnIniciarSesion.setOnClickListener { onRegistrar() }
        btnRegistro.setOnClickListener { onIniciarSesion() }
    }

    private fun initComponents() {
        etPassword = findViewById(R.id.etPassword)
        etPasswordC = findViewById(R.id.etPasswordC)
    }

    private fun verificarRegistro(): Boolean {
        val password = etPassword.text.toString()
        val passwordC = etPasswordC.text.toString()

        return if (password == passwordC) {
            Toast.makeText(this, "Epa son iguales", Toast.LENGTH_SHORT).show()
            true
        } else {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            false
        }
    }

    private fun onRegistrar() {
        if (verificarRegistro()) {
            Toast.makeText(this, "Va a la pagina principal", Toast.LENGTH_SHORT).show()
        }
    }


    private fun onIniciarSesion() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}