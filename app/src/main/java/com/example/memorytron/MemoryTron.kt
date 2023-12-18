package com.example.memorytron

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class MemoryTron : AppCompatActivity() {

    var imagenes_detras = mutableListOf<ImageView>()
    lateinit var imagenes_frontal: MutableList<Int>
    var carta_seleccionada: ImageView? = null
    var cartaPorDetras = R.drawable.carta_detras
    var vidas = mutableListOf<ImageView>()
    var contador_vidas = 4
    var ganar: Boolean? = null
    lateinit var bt_reiniciar: Button
    lateinit var tv_ganar_perder: TextView
    var contadorParejaCartas=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memorytron)
        bt_reiniciar = findViewById(R.id.bt_reiniciar)
        tv_ganar_perder = findViewById(R.id.tv_ganar_perder)
        bt_reiniciar.setOnClickListener{
            recreate()
        }

        vidas = mutableListOf(
            findViewById(R.id.corazon1),
            findViewById(R.id.corazon2),
            findViewById(R.id.corazon3),
            findViewById(R.id.corazon4),
            findViewById(R.id.corazon5)
        )

        imagenes_detras = mutableListOf(
            findViewById(R.id.img_1),
            findViewById(R.id.img_2),
            findViewById(R.id.img_3),
            findViewById(R.id.img_4),
            findViewById(R.id.img_5),
            findViewById(R.id.img_6),
            findViewById(R.id.img_7),
            findViewById(R.id.img_8),
            findViewById(R.id.img_9),
            findViewById(R.id.img_10),
            findViewById(R.id.img_11),
            findViewById(R.id.img_12)
        )

        imagenes_frontal = mutableListOf(
            R.drawable.carta_allah,
            R.drawable.carta_allah,
            R.drawable.carta_chinawtf,
            R.drawable.carta_chinawtf,
            R.drawable.carta_nani,
            R.drawable.carta_nani,
            R.drawable.carta_nig,
            R.drawable.carta_nig,
            R.drawable.carta_jhon_cena,
            R.drawable.carta_jhon_cena,
            R.drawable.carta_virus,
            R.drawable.carta_virus
        )
        imagenes_frontal.shuffle()



        imagenes_detras.forEachIndexed() { index, carta ->
            carta.setOnClickListener {
                cliclImagen(index, carta)
            }
        }
    }

    private fun cliclImagen(pos: Int, carta: ImageView) {
        carta.setImageResource(imagenes_frontal[pos])

        if (carta_seleccionada == null) {
            carta_seleccionada = carta
        } else {

            imagenes_detras.forEach { it.isClickable = false }

            carta.postDelayed({
                compararCartas(carta, carta_seleccionada!!)
                imagenes_detras.forEach { it.isClickable = true }
            }, 1000)


        }

    }

    private fun compararCartas(carta1: ImageView, carta2: ImageView) {
        val imagen = carta1.drawable
        val imagen2 = carta2.drawable

        if (imagen.constantState == imagen2.constantState) {
            carta1.isClickable = false
            carta2.isClickable = false
            contadorParejaCartas++
        } else {
            carta1.setImageResource(cartaPorDetras)
            carta2.setImageResource(cartaPorDetras)
            perderVidas()
        }

        carta_seleccionada = null
    }

    private fun perderVidas() {
        for (i in 0 until vidas.size) {
            if (contador_vidas == i) {
                vidas[i].setImageResource(R.drawable.corazon_vacio_img)
            }
        }

        contador_vidas--
        compGanarPerder(contador_vidas)
    }

    private fun compGanarPerder(vidas: Int) {
        if (vidas == -1) {
            ganar = false
            bloquearCartas()
        }
        if (contadorParejaCartas==6) {
            ganar=true
            bloquearCartas()
        }
        anunciarEstadoJuego()

    }

    private fun bloquearCartas() {
        imagenes_detras.forEach {
            it.isEnabled=false
        }
    }

    private fun anunciarEstadoJuego(){
        if (ganar != null) {
            bt_reiniciar.isVisible = true
            tv_ganar_perder.isVisible = true

            if (ganar!!) {
                tv_ganar_perder.text = "Has ganado!!"
            }
        }
    }

}