package com.ahmed.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
//ahmed elkomy
class Currency_Converter : AppCompatActivity() {
    val egypt = "Egyption pound"
    val america = "American dollar"
    val AED = "AED"
    val GBP = "GBP"
    val values = mapOf(
        america to 1.0,
        egypt to 30.90,
        GBP to 3.67,
        AED to 0.81,
    )

    lateinit var convert: Button
    lateinit var amountEt: TextInputEditText
    lateinit var resultEt: TextInputEditText
    lateinit var list: AutoCompleteTextView
    lateinit var from: AutoCompleteTextView
    private fun calculate() {
        if (amountEt.text.toString().isNotEmpty()) {
            val amount = amountEt.text.toString().toDouble()
            val tovalue = values[list.text.toString()]
            val fromvalue = values[from.text.toString()]
            val result = (amount.times(tovalue!!)).div(fromvalue!!)
            val format = String.format("%.4f",result)
            resultEt.setText(format)

        } else {
            amountEt.setError("enter value")
        }
    }

        override  fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_currency_converter)
            description()
            country()
            amountEt.addTextChangedListener{
                calculate()
            }
            list.setOnItemClickListener{adapterView, view,i,l ->
                calculate()

            }
            from.setOnItemClickListener{adapterView, view,i,l ->
                calculate()

            }
           /* convert.setOnClickListener {
                calculate()*/
                /*val snack =  Snackbar.make(amountEt,"amount is empty",Snackbar.LENGTH_LONG)
                snack.show()
                snack.setAction("ok"){
                    Toast.makeText(this,"enter amount ",Toast.LENGTH_LONG).show()
                    }
                    */
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