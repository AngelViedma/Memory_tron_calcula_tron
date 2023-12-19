package com.example.memorytron

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(val context: Context) {
    private val PREFERENCES_NAME = "preferences"
    private val CONTADOR = "contador"
    private val MINIMO = "minimo"
    private val MAXIMO = "maximo"
    private val ISSUMA = "suma"
    private val ISRESTA = "resta"
    private val ISMULTI = "multi"

    private fun getSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    fun getContador(): Int {
        return getSharedPreferences().getInt(CONTADOR, 20000)
    }

    fun setContador(segundos: Int) {
        this.getSharedPreferences().edit()?.putInt(CONTADOR, segundos)?.apply()
    }

    fun getMinimo(): Float {
        return getSharedPreferences().getFloat(MINIMO, 0f)
    }

    fun setMinimo(numero: Float) {
        this.getSharedPreferences().edit()?.putFloat(MINIMO, numero)?.apply()
    }

    fun getMaximo(): Float {
        return getSharedPreferences().getFloat(MAXIMO, 10f)
    }

    fun setMaximo(numero: Float) {
        this.getSharedPreferences().edit()?.putFloat(MAXIMO, numero)?.apply()
    }

    fun isSuma(): Boolean {
        return getSharedPreferences().getBoolean(ISSUMA, false)
    }

    fun setIsSuma(selected: Boolean) {
        this.getSharedPreferences().edit()?.putBoolean(ISSUMA, selected)?.apply()
    }

    fun isResta(): Boolean {
        return getSharedPreferences().getBoolean(ISRESTA, false)
    }

    fun setIsResta(selected: Boolean) {
        this.getSharedPreferences().edit()?.putBoolean(ISRESTA, selected)?.apply()
    }

    fun isMulti(): Boolean {
        return getSharedPreferences().getBoolean(ISMULTI, false)
    }

    fun setIsMulti(selected: Boolean) {
        this.getSharedPreferences().edit()?.putBoolean(ISMULTI, selected)?.apply()
    }

}