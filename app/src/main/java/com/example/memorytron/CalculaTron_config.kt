package com.example.memorytron

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.memorytron.databinding.ActivityCalculaTronConfigBinding

class CalculaTron_config : AppCompatActivity() {
    private lateinit var binding: ActivityCalculaTronConfigBinding
    private val preferences = AppPreferences(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculaTronConfigBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        initListeners()


    }

    private fun initListeners() {
        binding.btGuardarConfig.setOnClickListener {
            if (validarConfig()) {
                preferences.setContador(convertFromSecondsToMillis(binding.textContador.text.toString()))
                preferences.setMaximo(binding.textMax.text.toString().toFloat())
                preferences.setMinimo(binding.textMinimo.text.toString().toFloat())
                //ISSELECTED O ISCHECKED???
                preferences.setIsSuma(binding.checkSuma.isSelected)
                preferences.setIsResta(binding.checkResta.isSelected)
                preferences.setIsMulti(binding.checkMultiplicacion.isSelected)

                Toast.makeText(this, "Configuracion guardada", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, CalculaTron::class.java))
            }
        }
    }

    private fun validarConfig(): Boolean {
        var validar = true

        if (binding.textContador.text.toString().isNullOrEmpty()) {
            binding.textInputLayoutCuentaAtras.error = "El contador no puede estar vacio"
            validar = false
        } else {
            binding.textInputLayoutCuentaAtras.error = null
        }


        if (binding.textMinimo.text.toString().isNullOrEmpty()) {
            binding.textInputLayoutMinimo.error = "El minimo no puede estar vacio"
            validar = false
        } else {
            binding.textInputLayoutMinimo.error = null
        }
        if (binding.textMinimo.text.toString().contains("-")
        ) {
            binding.textInputLayoutMinimo.error =
                "El minimo solo permite numeros positivos y sin espacios"
            validar = false
        } else {
            binding.textInputLayoutMinimo.error = null
        }

        if (binding.textMax.text.toString().isNullOrEmpty()) {
            binding.layoutMax.error = "El maximo no puede estar vacio"
            validar = false
        } else {
            binding.layoutMax.error = null
        }

        if (binding.textMax.text.toString().contains("-")
        ) {
            binding.layoutMax.error = "El maximo solo permite numeros positivos y sin espacios"
        } else {
            binding.layoutMax.error = null
        }

        if (!binding.checkResta.isChecked && !binding.checkSuma.isChecked && !binding.checkMultiplicacion.isChecked) {
            binding.layoutCheckBox.error = "No has seleccionado ninguna operacion."
            validar = false
        } else {
            binding.layoutCheckBox.error = null
        }
        return validar
    }

    private fun convertFromSecondsToMillis(seconds: String): Int {
        return (seconds.toFloat() * 1000).toInt()
    }


}