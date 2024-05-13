package com.example.ejemplo10

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.DigitsKeyListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
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
    private lateinit var btnConvertir : Button
    private lateinit var btnChange : ImageButton
    private lateinit var btnCopiar : ImageButton
    private var change : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversion)
        initComponent()
        initListeners()
    }

    private fun initComponent(){
        txtCambio = findViewById(R.id.textIndicacion)
        convertir = findViewById(R.id.conversion0)
        conversion = findViewById(R.id.conversion1)
        //btnConvertir = findViewById(R.id.btnConversion)
        btnChange = findViewById(R.id.btnChange)
        btnCopiar = findViewById(R.id.btnCopiar)
    }

    private fun initListeners(){
            //btnConvertir.setOnClickListener {
              //  convert(change)
            //}

            btnChange.setOnClickListener {
                change(change)
            }

            btnCopiar.setOnClickListener{
                val textToCopy = conversion.text.toString()

                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("label", textToCopy)
                clipboard.setPrimaryClip(clip)

                Toast.makeText(this, "Texto copiado al portapapeles", Toast.LENGTH_SHORT).show()
            }

            convertir.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    convert(change)
                }

                override fun afterTextChanged(s: Editable?) {
                }
            })
    }

    private fun convert(tipo: Boolean){
        val valorString = convertir.text.toString()
        if (valorString.isNotEmpty()) {
            if(tipo == true){
                val valor = valorString.toLong()
                val valorBinario = java.lang.Long.toBinaryString(valor)
                val valorEditable = Editable.Factory.getInstance().newEditable(valorBinario.toString())
                conversion.text = valorEditable
            }else{
                val valorEntero = Integer.parseInt(valorString, 2)
                val valorEditable = Editable.Factory.getInstance().newEditable(valorEntero.toString())
                conversion.text = valorEditable
            }
        }else{
            conversion.setText("")
        }
    }

    private fun change(tipo: Boolean) {
        if (tipo) {
            convertir.keyListener = DigitsKeyListener.getInstance("01")

            convertir.setText("")
            conversion.setText("")

            txtCambio.text = "Binario a Decimal"
            change = false
        } else {
            convertir.keyListener = DigitsKeyListener.getInstance("0123456789")

            convertir.setText("")
            conversion.setText("")

            txtCambio.text = "Decimal a Binario"
            change = true
        }
    }
}