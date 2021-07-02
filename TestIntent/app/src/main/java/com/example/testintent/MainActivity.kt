package com.example.testintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var etName: EditText = findViewById<EditText>(R.id.et_name)
        var etId: EditText = findViewById<EditText>(R.id.et_id)
        var btnNext: Button = findViewById<Button>(R.id.btn_next)

        btnNext.setOnClickListener {
            var intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("name", etName.text.toString())
            intent.putExtra("id",Integer.parseInt(etId.text.toString()))

            startActivity(intent)
        }
    }
}