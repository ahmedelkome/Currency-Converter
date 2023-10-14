package com.ahmed.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class create_activity : AppCompatActivity() {
    lateinit var e1:EditText
    lateinit var e2:EditText
    lateinit var e3:EditText
    lateinit var back:Button
    lateinit var show:Button
    lateinit var res:TextView
    private fun description(){
        e1=findViewById(R.id.e1)
        e2=findViewById(R.id.e2)
        e3=findViewById(R.id.e3)
        back=findViewById(R.id.back_1)
        show=findViewById(R.id.show)
        res=findViewById(R.id.showre)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        description()
        show.setOnClickListener {
            var E1=e1.text.toString()
            var E2=e1.text.toString()
            var E3=e1.text.toString()
            var creat_text = "your email is : $E1 , your username : $E2 , your password : $E3"
            res.setText(creat_text.toString())
        }
        back.setOnClickListener {
            var Back = Intent(this,MainActivity::class.java)
            finish()

        }

    }
}