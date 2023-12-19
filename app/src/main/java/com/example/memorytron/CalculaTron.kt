package com.example.memorytron

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import com.example.memorytron.databinding.ActivityCalculaTronBinding

class CalculaTron : AppCompatActivity() {
    private lateinit var binding:ActivityCalculaTronBinding
    private val preferences=AppPreferences(this)
    private var contador:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCalculaTronBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        contador=preferences.getContador()
        val timer = object: CountDownTimer(contador.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.tvContador.text=(millisUntilFinished/1000).toString()
            }
            override fun onFinish() {
                //Logica al llegar a 0 en contador
            }
        }
        timer.start()

    }
}