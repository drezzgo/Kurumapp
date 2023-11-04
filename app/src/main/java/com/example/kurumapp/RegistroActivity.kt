package com.example.kurumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistroActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etPasswordC: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        initComponents()

        val btnRegistro = findViewById<Button>(R.id.btnRegistro)
        val btnIniciarSesion = findViewById<Button>(R.id.btnIniciarSesion)

        btnRegistro.setOnClickListener { onRegistrar() }
        btnIniciarSesion.setOnClickListener { onIniciarSesion() }
    }

    private fun initComponents() {
        etNombre = findViewById(R.id.etNombre)
        etPassword = findViewById(R.id.etPassword)
        etPasswordC = findViewById(R.id.etPasswordC)
        etEmail = findViewById(R.id.etEmail)
    }

    private fun verificarRegistro(): Boolean {
        val nombre = etNombre.text.toString()
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val passwordC = etPasswordC.text.toString()

        return if (nombre.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && passwordC.isNotEmpty() && password == passwordC) {
            Toast.makeText(this, "Epa son iguales", Toast.LENGTH_SHORT).show()
            true
        } else {
            Toast.makeText(this, if (nombre.isEmpty() || email.isEmpty()) "Completa el 0formulario" else "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            false
        }
    }


    private fun onRegistrar() {

        if (verificarRegistro()) {
            Toast.makeText(this, "Ya casi", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, RegistroFinalActivity::class.java)
            intent.putExtra("EXTRA_EMAIL", etEmail.text)
            intent.putExtra("EXTRA_PASSWORD", etPassword.text)
            intent.putExtra("EXTRA_NOMBRE", etNombre.text)
            startActivity(intent)
        }
    }


    private fun onIniciarSesion() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}