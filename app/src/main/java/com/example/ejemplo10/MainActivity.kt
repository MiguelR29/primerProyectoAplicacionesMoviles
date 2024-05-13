package com.example.ejemplo10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.ejemplo10.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnRegistro.setOnClickListener {
            val intento = Intent(this, RegisterActivity::class.java)
            startActivity(intento)
        }

        val correo_input = findViewById<AppCompatEditText>(R.id.editText)
        val contra_input = findViewById<AppCompatEditText>(R.id.editText2)

        binding.btnBorrar.setOnClickListener {
            correo_input.setText("")
            contra_input.setText("")
        }

        binding.btnInicio.setOnClickListener {
            val correo = binding.editText.text.toString()
            val contra = binding.editText2.text.toString()

            if(correo.isNotEmpty() && contra.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(correo, contra).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intento = Intent(this, ResultadoActivity::class.java)
                        startActivity(intento)
                    }else{
                        Toast.makeText(this, "Usuario/Contraseña no validos", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this, "Existen campos vacios", Toast.LENGTH_SHORT).show()
            }
        }
    }
}