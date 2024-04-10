package com.example.ejemplo10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import androidx.appcompat.widget.AppCompatButton

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)
        val textoNombre = findViewById<TextView>(R.id.textNombre)
        val texto:String = intent.extras?.getString("EXTRA_NOMBRE").orEmpty()
        textoNombre.text = "Hola $texto"

        val btnTemperatura = findViewById<AppCompatButton>(R.id.btnTemperatura)
        val btnConversion = findViewById<AppCompatButton>(R.id.btnConversion)
        val btnIMC = findViewById<AppCompatButton>(R.id.btnIMC)

        btnTemperatura.setOnClickListener {
            val intento = Intent(this, ConversorActivity::class.java)
            startActivity(intento)
        }

        btnConversion.setOnClickListener {
            val intento = Intent(this, ConversionActivity::class.java)
            startActivity(intento)
        }

        btnIMC.setOnClickListener {
            val intento = Intent(this, ImcActivity::class.java)
            startActivity(intento)
        }
    }
}