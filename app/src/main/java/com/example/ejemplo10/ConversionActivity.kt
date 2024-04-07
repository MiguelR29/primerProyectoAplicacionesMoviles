package com.example.ejemplo10

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConversionActivity : AppCompatActivity() {

    private lateinit var txtCambio : TextView
    private lateinit var convertir : EditText
    private lateinit var conversion : EditText
    private lateinit var btnConvertir : bu
    private var change : Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversion)
        


    }

    private fun initComponent(){
        txtCambio = findViewById(R.id.textIndicacion)
        convertir = findViewById(R.id.conversion0)
        conversion = findViewById(R.id.conversion1)
        btnConvertir = findViewById(R.id.btnConversion)



    }
}