package com.ahmed.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var emailEt : EditText
    lateinit var passEt: EditText
    lateinit var join : Button
    lateinit var create:Button
    private fun description () {
        emailEt = findViewById(R.id.email)
        passEt = findViewById(R.id.pass)
        join = findViewById(R.id.join)
        create=findViewById(R.id.creat)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        description()
        join.setOnClickListener {
            var Email = emailEt.text.toString()
            var Pass= passEt.text.toString()
            var text = "Hello your email : $Email \n your password : $Pass"
            var myintent = Intent(this,Second_activity::class.java)
            myintent.putExtra("Data",text)
            startActivity(myintent)

        }
        create.setOnClickListener {
            var createintent = Intent(this, create_activity::class.java)
            startActivity(createintent)
        }

    }

}
