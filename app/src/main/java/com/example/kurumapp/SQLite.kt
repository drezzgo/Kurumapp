package com.example.kurumapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLite(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE usuarios (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "nombre_concesionario TEXT UNIQUE," +
                "email TEXT UNIQUE," +
                "password TEXT," +
                "nombre TEXT," +
                "tipo_cuenta TEXT" +
                ")")
        usuarioAdmi(db)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Aquí debes proporcionar un script SQL para manejar actualizaciones de la base de datos si es necesario
    }

    private fun usuarioAdmi(db: SQLiteDatabase?) {
        val ejemploUsuario = ContentValues()
        ejemploUsuario.put("nombre_concesionario", "kurumapp")
        ejemploUsuario.put("email", "drezzgo@ejemplo.com")
        ejemploUsuario.put("password", "123456")
        ejemploUsuario.put("nombre", "Andres Gongora")
        ejemploUsuario.put("tipo_cuenta", "Administrador")

        db?.insert("usuarios", null, ejemploUsuario)
    }

}
