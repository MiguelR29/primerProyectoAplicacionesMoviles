package com.example.ejemplo10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.slider.Slider
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {

    private lateinit var sliderAltura : Slider
    private lateinit var sliderPeso : Slider
    private lateinit var txtAltura : TextView
    private lateinit var txtPeso : TextView
    private lateinit var editResultado : EditText
    private lateinit var txtNota : TextView
    private  var altura : Float = 0f
    private var peso : Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        initComponent()
        initListeners()
    }

    private fun initComponent(){
        sliderAltura = findViewById(R.id.sliderAltura)
        sliderPeso = findViewById(R.id.sliderPeso)
        txtAltura = findViewById(R.id.txtAltura)
        txtPeso = findViewById(R.id.txtPeso)
        editResultado = findViewById((R.id.editResultado))
        txtNota = findViewById(R.id.txtNotaResultado)
    }

    private fun initListeners(){
        sliderAltura.addOnChangeListener { slider, value, _ ->
            val aux = DecimalFormat("#.##")
            val result = aux.format(value)

            altura = value
            IMC()

            txtAltura.text = "$result CM"
        }

        sliderPeso.addOnChangeListener { slider, value, _ ->
            val aux = DecimalFormat("#.##")
            val result = aux.format(value)

            peso = value
            IMC()

            txtPeso.text = "$result KG"
        }
    }

    private fun IMC(){
        val IMC = (peso)/((altura/100)*(altura/100))
        editResultado.setText("$IMC")

        if(IMC < 18.5f){
            txtNota.text = "Bajo"
        }else if(IMC >= 18.5f && IMC <= 24.9){
            txtNota.text = "Normal"
        }else if(IMC >= 25 && IMC <= 29.9){
            txtNota.text = "Sobrepeso"
        }else{
            txtNota.text = "Obesidad"
        }
    }
}