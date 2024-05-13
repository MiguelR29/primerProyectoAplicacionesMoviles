package com.example.ejemplo10


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.ejemplo10.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_register)

        //val botonVolver = findViewById<AppCompatButton>(R.id.btnVolver)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnVolver.setOnClickListener {
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
        }

        binding.btnRegistro.setOnClickListener {
            val correo = binding.editText1.text.toString()
            val contra = binding.editText2.text.toString()
            val confirmcontra = binding.editText3.text.toString()

            if(correo.isNotEmpty() && contra.isNotEmpty() && confirmcontra.isNotEmpty()){
                if(contra == confirmcontra){
                    firebaseAuth.createUserWithEmailAndPassword(correo, contra).addOnCompleteListener {
                        if(it.isSuccessful){
                            val intento = Intent(this, MainActivity::class.java)
                            startActivity(intento)
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Existen campos vacios", Toast.LENGTH_SHORT).show()
            }
        }



    /*
    botonVolver.setOnClickListener {
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
        }*/
    }
}

