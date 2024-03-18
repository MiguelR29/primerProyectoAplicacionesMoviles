package com.example.ejemplo10


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.slider.Slider
import java.text.DecimalFormat
import kotlin.math.roundToInt

class ConversorActivity : AppCompatActivity() {
    //Se deja fuera de override, que se inicialicen las variables hasta que se les de click.
    //Asi la guardamos sin algun valor
    private lateinit var cardCel : CardView
    private lateinit var cardFar : CardView
    private lateinit var cardKel : CardView
    private lateinit var sliderTemp : Slider
    private lateinit var txtTemp : TextView
    private var selected : Int = 1
    private var isCel : Boolean = true
    private var isFar : Boolean = false
    private var isKel : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor)
        initComponent()
        initListeners()
        setTempColor()
    }

    private fun initComponent(){
        cardCel = findViewById(R.id.card0)
        cardFar = findViewById(R.id.card1)
        cardKel = findViewById(R.id.card2)
        sliderTemp = findViewById(R.id.sliderTemperature)
        txtTemp = findViewById(R.id.txtTemp)
    }

    private fun cambioTemp(tipo : Int){
        isCel = tipo == 1
        isFar = tipo == 2
        isKel = tipo == 3
        if(selected != 0) changeGrades(selected, tipo)
        selected = tipo
    }

    private fun changeGrades(selected: Int, tipo: Int) {
        val temperaturaString = txtTemp.text.toString().replace(" °", "")
        val temperatura = temperaturaString.toFloat()
        var temperaturaFinal = temperatura
        var slideMin : Float = 0f
        var slideMax : Float = 0f
        sliderTemp.value = 0f

        when (selected) {
            1 -> {
                when (tipo) {
                    2 -> temperaturaFinal = (temperatura * 9f/5f) + 32f // Celsius a Fahrenheit
                    3 -> temperaturaFinal = temperatura + 273.15f // Celsius a Kelvin
                }
            }
            2 -> {
                when (tipo) {
                    1 -> temperaturaFinal = (temperatura - 32f) * 5f/9f // Fahrenheit a Celsius
                    3 -> temperaturaFinal = (temperatura - 32f) * 5f/9f + 273.15f // Fahrenheit a Kelvin
                }
            }
            3 -> {
                when (tipo) {
                    1 -> temperaturaFinal = temperatura - 273.15f // Kelvin a Celsius
                    2 -> temperaturaFinal = (temperatura - 273.15f) * 9f/5f + 32f // Kelvin a Fahrenheit
                }
            }
        }

        when(tipo){
            1 -> {slideMin = -100f
                slideMax = 100f}
            2 -> {slideMin = -148f
            slideMax = 220f}
            3 -> { slideMin = 0f
                slideMax = 374f
            }
        }

        val stepSize = sliderTemp.stepSize
        temperaturaFinal = (temperaturaFinal / stepSize).roundToInt() * stepSize

        if(temperaturaFinal <= slideMin){
            temperaturaFinal = slideMin
        }

        if(temperaturaFinal >= slideMax){
            temperaturaFinal = slideMax
        }

        txtTemp.text = "$temperaturaFinal °"
        println(slideMin)
        println(slideMax)
        sliderTemp.valueFrom = slideMin
        sliderTemp.valueTo = slideMax
        sliderTemp.value = temperaturaFinal
    }

    private fun initListeners(){
        cardCel.setOnClickListener{
            cambioTemp(1)
            setTempColor()
        }
        cardFar.setOnClickListener{
            cambioTemp(2)
            setTempColor()
        }
        cardKel.setOnClickListener{
            cambioTemp(3)
            setTempColor()
        }

        sliderTemp.addOnChangeListener { slider, value, _ ->
            val aux = DecimalFormat("#.##")
            val result = aux.format(value)

            txtTemp.text = "$result °"
        }
    }

    private fun setTempColor(){
        cardCel.setCardBackgroundColor(getBackgroundColor((isCel)))
        cardFar.setCardBackgroundColor(getBackgroundColor((isFar)))
        cardKel.setCardBackgroundColor(getBackgroundColor((isKel)))
    }

    private fun getBackgroundColor(isSeleccionado:Boolean) : Int{
        val referenciaColor = if(isSeleccionado == true){
            R.color.principal
        }else{
            R.color.principal2
        }
        return ContextCompat.getColor(this, referenciaColor)
    }


}

