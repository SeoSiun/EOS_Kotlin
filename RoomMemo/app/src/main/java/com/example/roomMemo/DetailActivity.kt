package com.example.roomMemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val et_title = findViewById<EditText>(R.id.etTitle)
        val et_content = findViewById<EditText>(R.id.etContent)
        val iv_save = findViewById<ImageView>(R.id.imageSave)
        val iv_delete = findViewById<ImageView>(R.id.imageDelete)

        var memo = intent.getSerializableExtra("memo") as RoomMemo

        et_title.setText(memo.title)
        et_content.setText(memo.content)

        iv_save.setOnClickListener{
            // 제목과 내용이 둘 다 있을 때 main으로 돌아가기.
            if(et_title.text.toString().isNotEmpty() && et_content.text.toString().isNotEmpty()) {
                memo.title = et_title.text.toString()
                memo.content = et_content.text.toString()

                val returnIntent = Intent()
                returnIntent.putExtra("returnMemo",memo)

                // 결과값 설정
                setResult(Activity.RESULT_OK, returnIntent)

                // 액티비티 종료, 이전 액티비티로 돌아감
                finish()
            }
            else if(et_title.text.toString().isNotEmpty()) {
                Toast.makeText(this, "내용이 비어있습니다.", Toast.LENGTH_SHORT).show()
            }
            else if(et_content.text.toString().isNotEmpty()) {
                Toast.makeText(this, "제목이 비어있습니다.", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "제목과 내용이 비어있습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        iv_delete.setOnClickListener {
            setResult(Activity.RESULT_CANCELED, Intent().putExtra("returnMemo", memo))

            finish()
        }
    }
}