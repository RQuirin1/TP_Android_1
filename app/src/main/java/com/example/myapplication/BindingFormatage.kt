package com.example.myapplication

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.DecimalFormat

object BindingFormatage {
    @BindingAdapter("formatage")
    @JvmStatic
    fun formatage(textView: TextView, formatage: String) {
        var df = DecimalFormat("#.##")
        textView.text = df.format(formatage.toDouble()).replace(',', '.')
    }


}