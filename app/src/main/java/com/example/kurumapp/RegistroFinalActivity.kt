package com.example.kurumapp

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroFinalActivity : AppCompatActivity() {
    private lateinit var extraname: String
    private lateinit var extraemail: String
    private lateinit var extrapassword: String
    private var etConcesionario: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_final)
        etConcesionario = findViewById(R.id.etConcensionario)
        extraname = intent.getStringExtra("EXTRA_NAME") ?: ""
        extraemail = intent.getStringExtra("EXTRA_EMAIL") ?: ""
        extrapassword = intent.getStringExtra("EXTRA_PASSWORD") ?: ""

        val btnRegistroF = findViewById<Button>(R.id.btnRegistroF)
        btnRegistroF.setOnClickListener { insertar() }
    }

    private fun insertar() {
        val concesionario = etConcesionario?.text.toString()
        val email = extraemail
        val password = extrapassword
        val name = extraname


        if (concesionario.isNotEmpty()) {
            val conexion = SQLite(this, "Concesionario", null, 1)
            val bd = conexion.writableDatabase
            val registro = ContentValues()
            registro.put("nombre_concesionario", concesionario)
            registro.put("email", email)
            registro.put("password", password)
            registro.put("nombre", name)
            bd.insert("usuarios", null, registro)
            etConcesionario?.setText("")
            Toast.makeText(this, "Se ha registrado exitosamente", Toast.LENGTH_LONG).show()
            conexion.close()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Ponle un nombre al concensionario", Toast.LENGTH_SHORT).show()
        }
    }

}