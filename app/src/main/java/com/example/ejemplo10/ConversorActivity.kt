package com.example.ejemplo10


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class ConversorActivity : AppCompatActivity() {
    //Se deja fuera de override, que se inicialicen las variables hasta que se les de click.
    //Asi la guardamos sin algun valor
    private lateinit var cardCel : CardView
    private lateinit var cardFar : CardView
    private lateinit var cardKel : CardView
    private var isCel : Boolean = false
    private var isFar : Boolean = false
    private var isKel : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor)
        initComponent()
        initListeners()
    }



    private fun initComponent(){
        cardCel = findViewById(R.id.card0)
        cardFar = findViewById(R.id.card1)
        cardKel = findViewById(R.id.card2)
    }

    private fun cambioTemp(tipo : Int){
        isCel = tipo == 1
        isFar = tipo == 2
        isKel = tipo == 3
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