package com.android.nbc_login

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val loginId = intent.getStringExtra("SignIn")
        val tv = findViewById<TextView>(R.id.tv_info)
        tv.setText(
            "아이디 : $loginId \n\n" +
                    "이름: 치킨먹고싶다아\n\n" +
                    "나이: 23\n\n" +
                    "MBTI: INFP"
        )
    }

    fun doFinish() = finish()
}