package com.example.ejemplo10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botonLogin = findViewById<AppCompatButton>(R.id.btnInicio)
        val botonBorrar = findViewById<AppCompatButton>(R.id.btnBorrar)
        val botonRegister = findViewById<AppCompatButton>(R.id.btnRegistro)
        val usuario = findViewById<AppCompatEditText>(R.id.editText)
        val contra = findViewById<AppCompatEditText>(R.id.editText2)

        botonLogin.setOnClickListener {
            val textUsuario = usuario.text.toString()
            val textContra = contra.text.toString()
            if (textUsuario.isNotEmpty() && textContra.isNotEmpty()) {
                val intento = Intent(this, ResultadoActivity::class.java)
                intento.putExtra("EXTRA_NOMBRE", textUsuario)
                intento.putExtra("EXTRA_CONTRA", textContra)
                startActivity(intento)
                }
        }

        botonBorrar.setOnClickListener {
            usuario.setText("")
            contra.setText("")
        }

        botonRegister.setOnClickListener {
            val intento = Intent(this, RegisterActivity::class.java)
            startActivity(intento)
        }
    }
}