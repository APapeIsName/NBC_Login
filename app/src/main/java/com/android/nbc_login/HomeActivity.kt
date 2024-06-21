package com.android.nbc_login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

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
        tv.text = "아이디 : $loginId \n\n" +
                "이름: 치킨먹고싶다아\n\n" +
                "나이: 23\n\n" +
                "MBTI: INFP"
        val iv = findViewById<ImageView>(R.id.iv_chicken)
        val imageResources = intArrayOf(
            R.drawable.kyochon_1,
            R.drawable.kyochon_2,
            R.drawable.kyochon_3,
            R.drawable.kyochon_4,
            R.drawable.kyochon_5,
        )
        val random = Random.nextInt(5)
        Log.e("randomValue", "$random")
        iv.setImageResource(imageResources[random])
    }

    fun doFinish(view: View) = finish()
}