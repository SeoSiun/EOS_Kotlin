package com.example.memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun makeDummyData(): MutableList<Memo> {
            val data: MutableList<Memo> = mutableListOf()

            for(no in 1..10) {
                val title = "이것은 ${no} 번째 제목"
                val content = "이것은 ${no} 번째 내용"
                val date = System.currentTimeMillis()
                var memo = Memo(no, title, content, date)
                data.add(memo)
            }
            return data
        }

        val adapter = RecyclerAdapter()

        val recyclerMemo = findViewById<RecyclerView>(R.id.recyclerMemo)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)

        adapter.listData = makeDummyData()

        recyclerMemo.adapter = adapter
        recyclerMemo.layoutManager = LinearLayoutManager(this)

        buttonAdd.setOnClickListener {
            Toast.makeText(this, "Add button", Toast.LENGTH_SHORT).show()

/*            val title = "이것은 ${adapter.listData.size} 번째 제목"
            val content = "이것은 ${adapter.listData.size} 번째 내용"
            val date = System.currentTimeMillis()
            var memo = Memo(adapter.listData.size, title, content, date)
            adapter.listData.add(memo)
            recyclerMemo.adapter = adapter*/
        }
    }
}