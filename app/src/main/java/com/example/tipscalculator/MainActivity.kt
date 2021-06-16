package com.example.tipscalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Text fields
        val subtotal = findViewById<EditText>(R.id.subtotal)
        val tax = findViewById<TextView>(R.id.tax)
        val tip = findViewById<TextView>(R.id.tip)
        val total = findViewById<TextView>(R.id.total)

        //Tip Buttons
        val tipFifteen = findViewById<Button>(R.id.tipFifteen)
        val tipEighteen = findViewById<Button>(R.id.tipEighteen);
        val tipTwenty = findViewById<Button>(R.id.tipTwenty);

        val tipPercentage: MutableLiveData<Double> = MutableLiveData<Double>()
        tipPercentage.value = 0.00

        tipPercentage.observe(context, {
            var temp:Double = 0.0
            tipPercentage?.let{value -> temp = value}
            tip.text = (subtotal.text.toString().toDouble() * temp).toString()
        })

        tax.text = (subtotal.text.toString().toDouble() * 0.06).toString()

        tipFifteen.setOnClickListener{
            tipPercentage.value = 0.15
        }
    }
}