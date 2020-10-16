package com.adityaraj.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et.text = ""
        rslt.text = ""


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
            evaluateExpression("+", clear = true)
        }

        subs.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        multiply.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        divide.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        dot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }
        power.setOnClickListener {
            evaluateExpression("^", clear = true)
        }
        root.setOnClickListener {
            evaluateExpression("%", clear = true)
        }

        clr.setOnLongClickListener{
            clear_all()
            true
         }

        equal.setOnClickListener {
            val text = et.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val df = DecimalFormat("#.#########")
            df.roundingMode = RoundingMode.CEILING


            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                rslt.text = df.format(longResult).toString()
            } else {
                rslt.text = df.format(result).toString()
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















