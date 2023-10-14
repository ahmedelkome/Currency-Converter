package com.ahmed.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class Second_activity : AppCompatActivity() {
    lateinit var re :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        re=findViewById(R.id.text1)
        var mydata = intent.getStringExtra("Data")
        re.setText(mydata.toString())




    }
}