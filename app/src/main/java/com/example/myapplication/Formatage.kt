package com.example.myapplication

import java.text.DecimalFormat

object Formatage {

    fun formatResult(form:String):String{
        var df = DecimalFormat("#.##")
        var result:String = df.format(form.toDouble())
        return result
    }

}