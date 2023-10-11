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
    val GBP="GBP"
    val values = mapOf(
        america to 1.0 ,
        egypt to 30.90 ,
        AED to 8.41 ,
        GBP to 38.01
    )
    lateinit var  convert : Button
    lateinit var amountEt : TextInputEditText
    lateinit var resultEt : TextInputEditText
    lateinit var list:AutoCompleteTextView
    lateinit var from : AutoCompleteTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_converter)
        description()
        country()
        convert.setOnClickListener {
            val amount = amountEt.text.toString().toDouble()
            val tovalue =values [list.text.toString()]
            val fromvalue = values[from.text.toString()]
            val result = amount.times(tovalue!!.div(fromvalue!!))
            resultEt.setText(result.toString())
        }





    /*  val amount = amountEt.text.toString().toDouble()
            val country = list.text.toString()
            var result = when (country){
                egypt -> amount.times(30.90)
                AED -> amount.times(3.67)
                GBP -> amount.times(0.82)
                else -> {
                    amount.times(1)
                }
            }

            resultEt.setText(result.toString())

        }*/

    }
    private fun description(){
        convert  = findViewById(R.id.conv_b)
        amountEt = findViewById(R.id.amount)
        resultEt = findViewById(R.id.result)
        list = findViewById(R.id.list2)
        from = findViewById(R.id.from)
    }
    private fun country(){
        val listofcountry= listOf(egypt,america,AED,GBP)
        val adapter = ArrayAdapter(this,R.layout.text_file,listofcountry)
        list.setAdapter(adapter)
        from.setAdapter(adapter)
    }
}