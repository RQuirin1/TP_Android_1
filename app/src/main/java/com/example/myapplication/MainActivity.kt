package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {


    private var taux = 0.0
    private var bas:Double? = 0.0
    private var haut:Double? = 0.0
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataForCalculs: DataForCalculs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataForCalculs = DataForCalculs("0.0","0.0")
        binding.infoCalculs = dataForCalculs
        selectButton()

        binding.buttonBas.setOnClickListener {
            if(binding.editTextHaut.text.toString().isNotEmpty()){
                bas = binding.editTextHaut.text.toString().toDouble() * taux
                binding.editTextBas.setText(bas.toString())
                dataForCalculs = DataForCalculs(binding.editTextHaut.text.toString(), bas.toString())
                binding.infoCalculs = dataForCalculs

            } else {
                Toast.makeText(this,"Saisie invalide", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonHaut.setOnClickListener {
            if (binding.editTextBas.text.toString().isNotEmpty()) {
                haut = binding.editTextBas.text.toString().toDouble() / taux
                binding.editTextHaut.setText(haut.toString())
                dataForCalculs = DataForCalculs(haut.toString(), bas.toString())
                binding.infoCalculs = dataForCalculs
            } else {
                Toast.makeText(this, "Saisie invalide", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonEuDo.setOnClickListener {
            modifLabel(1.09, "Euro", "Dollar")
        }

        binding.buttonEuYen.setOnClickListener{
            modifLabel(169.0, "Euro", "Yen")
        }

        binding.buttonDoYen.setOnClickListener {
            modifLabel(152.0, "Dollar", "Yen")
        }

    }

    fun modifLabel(taux:Double, labelHaut:String, labelBas:String){
        this.taux = taux
        binding.infoIHM = DataForBinding(labelHaut,labelBas)
    }

    fun selectButton(){
        binding.buttonEuDo.performClick()
        modifLabel(1.09, "Euro", "Dollar")
    }
}