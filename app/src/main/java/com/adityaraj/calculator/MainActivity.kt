package com.adityaraj.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et.text = ""
        rslt.text = ""
        var counter = 0
        var counters  = 1
        val bracket = "("
        val brackets = ")"




        bt1.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        bt2.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        bt3.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        bt4.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        bt5.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        bt6.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        bt7.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        bt8.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        bt9.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        bt0.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        add.setOnClickListener {
            if (rslt.text.isEmpty()){
                evaluateExpression("+", clear = true)
            }else{
                et.text = ""
                evaluateExpression(rslt.text.toString(),clear = true)
                evaluateExpression("+", clear = true)
            }

        }

        subs.setOnClickListener {

            if (rslt.text.isEmpty()){
                evaluateExpression("-", clear = true)
            }else{
                et.text = ""
                evaluateExpression(rslt.text.toString(),clear = true)
                evaluateExpression("-", clear = true)
            }
        }

        multiply.setOnClickListener {

            if (rslt.text.isEmpty()){
                evaluateExpression("*", clear = true)
            }else{
                et.text = ""
                evaluateExpression(rslt.text.toString(),clear = true)
                evaluateExpression("*", clear = true)
            }
        }

        divide.setOnClickListener {

            if (rslt.text.isEmpty()){
                evaluateExpression("/", clear = true)
            }else{
                et.text = ""
                evaluateExpression(rslt.text.toString(),clear = true)
                evaluateExpression("/", clear = true)
            }
        }

        dot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }
        power.setOnClickListener {

            if (rslt.text.isEmpty()){
                evaluateExpression("^", clear = true)
            }else{
                et.text = ""
                evaluateExpression(rslt.text.toString(),clear = true)
                evaluateExpression("^", clear = true)
            }
        }
        root.setOnClickListener {

            if (rslt.text.isEmpty()){
                evaluateExpression("(", clear = true)
            }else{
                et.text = ""
                evaluateExpression(rslt.text.toString(),clear = true)
                evaluateExpression("(", clear = true)
            }
            Toast.makeText(this,"FOR CLOSING BRACKET ')',LONG PRESS () BUTTON ", Toast.LENGTH_LONG).show()

        }
        root.setOnLongClickListener{
            evaluateExpression(")", clear = true)
           // Toast.makeText(this,"LONG PRESS () FOR CLOSING BRACKET')'", Toast.LENGTH_LONG).show()
            true

        }


        clr.setOnLongClickListener{
            clear_all()
            true

        }


        var history = arrayOf("history")
        equal.setOnClickListener {
            try{
                var text = et.text.toString()
                val expression = ExpressionBuilder(text).build()
                val result = expression.evaluate()
                rslt.text = (result).toDouble().toString()
                history = history.plus(result.toString())
            }catch (e:Exception){
                Toast.makeText(this,"INVALID ARITHMETIC INPUT", Toast.LENGTH_LONG).show()
            }




        }

        clr.setOnClickListener {
            val text = et.text.toString()
            if (text.isNotEmpty()) {
                et.text = text.dropLast(1)
            }

            rslt.text = ""
        }
    }

    fun evaluateExpression(string: String, clear: Boolean) {
        if (clear) {
            rslt.text = ""
            et.append(string)
        } else {
            et.append(rslt.text)
            et.append(string)
            rslt.text = ""
        }
    }
    fun clear_all() {
        et.text=""
        rslt.text = ""
    }

}















