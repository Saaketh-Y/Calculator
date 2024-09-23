package com.cs407.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val inputField1 = findViewById<EditText>(R.id.inputField1)
        val inputField2 = findViewById<EditText>(R.id.inputField2)

        findViewById<Button>(R.id.addButton).setOnClickListener {
            val number1 = inputField1.text.toString().toDoubleOrNull()
            val number2 = inputField2.text.toString().toDoubleOrNull()

            if (number1 == null || number2 == null) {
                Toast.makeText(this, "Enter valid numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = number1 + number2
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result)
            startActivity(intent)
        }

        findViewById<Button>(R.id.subtractButton).setOnClickListener {
            val number1 = inputField1.text.toString().toDoubleOrNull()
            val number2 = inputField2.text.toString().toDoubleOrNull()

            if (number1 == null || number2 == null) {
                Toast.makeText(this, "Enter valid numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = number1 - number2
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result)
            startActivity(intent)
        }

        findViewById<Button>(R.id.multiplyButton).setOnClickListener {
            val number1 = inputField1.text.toString().toDoubleOrNull()
            val number2 = inputField2.text.toString().toDoubleOrNull()

            if (number1 == null || number2 == null) {
                Toast.makeText(this, "Enter valid numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = number1 * number2
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result)
            startActivity(intent)
        }

        findViewById<Button>(R.id.divideButton).setOnClickListener {
            val number1 = inputField1.text.toString().toDoubleOrNull()
            val number2 = inputField2.text.toString().toDoubleOrNull()

            if (number1 == null || number2 == null) {
                Toast.makeText(this, "Enter valid numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (number2 == 0.0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = number1 / number2
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT", result)
            startActivity(intent)
        }

    }
}