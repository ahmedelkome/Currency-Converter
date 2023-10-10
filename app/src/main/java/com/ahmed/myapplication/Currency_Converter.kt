package com.ahmed.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class Currency_Converter : AppCompatActivity() {
    val egypt ="Egyption pound"
    val america ="American dollar"
    val AED="AED"
    val GED="GED"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_converter)
        val convert:Button = findViewById(R.id.conv_b)
        val amountEt:TextInputEditText = findViewById(R.id.amount)
        val resultEt : TextInputEditText = findViewById(R.id.result)
        val list:AutoCompleteTextView =findViewById(R.id.list2)
        val listofcountry= listOf(egypt,america,AED,GED)
        val adapter = ArrayAdapter(this,R.layout.text_file,listofcountry)
        list.setAdapter(adapter)

        convert.setOnClickListener {
            val amount = amountEt.text.toString().toDouble()
            val country = list.text.toString()
            var result = when (country){
                egypt -> amount.times(30.90)
                AED -> amount.times(3.67)
                GED -> amount.times(0.82)
                else -> {
                    amount.times(1)
                }
            }

            resultEt.setText(result.toString())

        }

    }
}