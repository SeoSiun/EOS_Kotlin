package com.example.testintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var tvName: TextView = findViewById(R.id.tv_name)
        var tvId: TextView = findViewById(R.id.tv_id)
        var btnBack: Button = findViewById(R.id.btn_back)
        var btnSet: Button = findViewById(R.id.btn_set)

        btnSet.setOnClickListener {
            tvName.text = intent.getStringExtra("name")
            tvId.text = "${intent.getIntExtra("id",0)}"
        }

        btnBack.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}