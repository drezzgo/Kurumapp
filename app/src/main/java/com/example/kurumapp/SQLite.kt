package com.example.kurumapp

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
                "email TEXT," +
                "password TEXT," +
                "nombre TEXT" +
                ")")
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Aquí debes proporcionar un script SQL para manejar actualizaciones de la base de datos si es necesario
    }
}
