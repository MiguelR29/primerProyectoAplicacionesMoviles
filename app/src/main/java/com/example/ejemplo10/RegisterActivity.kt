package com.example.ejemplo10


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val botonVolver = findViewById<AppCompatButton>(R.id.btnVolver)
        val botonRegister = findViewById<AppCompatButton>(R.id.btnRegistro)
        val nombre = findViewById<AppCompatEditText>(R.id.editText0)
        val correo = findViewById<AppCompatEditText>(R.id.editText1)
        val usuario = findViewById<AppCompatEditText>(R.id.editText2)
        val contra = findViewById<AppCompatEditText>(R.id.editText3)

        botonRegister.setOnClickListener {
            val textNombre = nombre.text.toString()
            val textCorreo = correo.text.toString()
            val textUsuario = usuario.text.toString()
            val textContra = contra.text.toString()

            if (textUsuario.isNotEmpty() && textContra.isNotEmpty() && textNombre.isNotEmpty() && textCorreo.isNotEmpty()) {
                val intento = Intent(this, MainActivity::class.java)
                startActivity(intento)
                }
        }

        botonVolver.setOnClickListener {
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
        }
    }
}