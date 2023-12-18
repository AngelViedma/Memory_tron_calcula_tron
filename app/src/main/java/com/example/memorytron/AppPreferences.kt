package com.example.memorytron

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(val context:Context){
    private val PREFERENCES_NAME="preferences"
    private val CONTADOR="contador"
    private val MINIMO="minimo"
    private val MAXIMO="maximo"
    private val ISSUMA="suma"
    private val ISRESTA="resta"
    private val ISMULTI="multi"

    private fun getSharedPreferences():SharedPreferences{
        return context.getSharedPreferences(PREFERENCES_NAME,Context.MODE_PRIVATE)
    }

    private fun getContador():Int{
        return getSharedPreferences().getInt(CONTADOR,20000)
    }
    private fun setContador(segundos:Int){
        this.getSharedPreferences().edit()?.putInt(CONTADOR,segundos)?.apply()
    }
    private fun getMinimo():Float{
        return getSharedPreferences().getFloat(MINIMO,0f)
    }
    private fun setMinimo(numero:Float){
        this.getSharedPreferences().edit()?.putFloat(MINIMO,numero)?.apply()
    }
    private fun getMaximo():Float{
        return getSharedPreferences().getFloat(MAXIMO,10f)
    }
    private fun setMaximo(numero:Float){
        this.getSharedPreferences().edit()?.putFloat(MAXIMO,numero)?.apply()
    }

    private fun isSuma():Boolean{
        return getSharedPreferences().getBoolean(ISSUMA,false)
    }
    private fun setIsSuma(selected:Boolean){
        this.getSharedPreferences().edit()?.putBoolean(ISSUMA,selected)?.apply()
    }

    private fun isResta():Boolean{
        return getSharedPreferences().getBoolean(ISRESTA,false)
    }
    private fun setIsResta(selected:Boolean){
        this.getSharedPreferences().edit()?.putBoolean(ISRESTA,selected)?.apply()
    }

    private fun isMulti():Boolean{
        return getSharedPreferences().getBoolean(ISMULTI,false)
    }
    private fun setIsMulti(selected:Boolean){
        this.getSharedPreferences().edit()?.putBoolean(ISMULTI,selected)?.apply()
    }

}