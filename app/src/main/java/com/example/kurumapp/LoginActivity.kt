package com.example.kurumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)

        val btnIniciarSesion = findViewById<Button>(R.id.btnIniciarSesion)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro)

        btnIniciarSesion.setOnClickListener { iniciarSesion() }
        btnRegistro.setOnClickListener { onRegistro() }
    }
    private fun iniciarSesion() {
        val conexion = SQLite(this, "Concesionario", null, 1)
        val bd = conexion.writableDatabase
        val email = etEmail?.text.toString()
        val password = etPassword?.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            val fila = bd.rawQuery(
                "SELECT email, password, nombre " +
                        "FROM usuarios " +
                        "WHERE email='$email'", null
            )

            if (fila.moveToFirst()) { // Verifica si existe un resultado en la consulta
                val emailBD = fila.getString(0)
                val passwordBD = fila.getString(1)
                val nombre = fila.getString(2)

                if (password == passwordBD) {
                    Toast.makeText(this, "Bienvenido $nombre", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, RegistroActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show()
            }
            fila.close()
        }else{
            Toast.makeText(this, "Por favor, ingrese su email y contraseña", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onRegistro() {
        val intent = Intent(this, RegistroActivity::class.java)
        startActivity(intent)
    }
}