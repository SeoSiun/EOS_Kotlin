package com.example.roomMemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.roomMemo.databinding.ActivityDetailBinding
import com.example.roomMemo.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding

    var title = ""
    var content = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

//        val et_title = findViewById<EditText>(R.id.etTitle)
//        val et_content = findViewById<EditText>(R.id.etContent)
//        val iv_save = findViewById<ImageView>(R.id.imageSave)
//        val iv_delete = findViewById<ImageView>(R.id.imageDelete)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.activity = this

        var memo = intent.getSerializableExtra("memo") as RoomMemo

//        et_title.setText(memo.title)
//        et_content.setText(memo.content)

        title = memo.title
        content = memo.content

        binding.imageSave.setOnClickListener{
            // 제목과 내용이 둘 다 있을 때 main으로 돌아가기.
            if(title.isNotEmpty() && content.isNotEmpty()) {
                memo.title = title
                memo.content = content

                val returnIntent = Intent()
                returnIntent.putExtra("returnMemo",memo)

                // 결과값 설정
                setResult(Activity.RESULT_OK, returnIntent)

                // 액티비티 종료, 이전 액티비티로 돌아감
                finish()
            }
            else if(title.isNotEmpty()) {
                Toast.makeText(this, "내용이 비어있습니다.", Toast.LENGTH_SHORT).show()
            }
            else if(content.isNotEmpty()) {
                Toast.makeText(this, "제목이 비어있습니다.", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "제목과 내용이 비어있습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.imageDelete.setOnClickListener {
            setResult(Activity.RESULT_CANCELED, Intent().putExtra("returnMemo", memo))

            finish()
        }
    }
}