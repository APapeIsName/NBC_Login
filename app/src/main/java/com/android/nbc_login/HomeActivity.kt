package com.android.nbc_login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    val imageResources = intArrayOf(
        R.drawable.kyochon_1,
        R.drawable.kyochon_2,
        R.drawable.kyochon_3,
        R.drawable.kyochon_4,
        R.drawable.kyochon_5,
    )
    val urlResources = arrayOf(
        "https://m.kyochon.com/menu/menu_view?product_id=30098&depth1=2",
        "https://m.kyochon.com/menu/menu_view?product_id=30161&depth1=2",
        "https://m.kyochon.com/menu/menu_view?product_id=30022&depth1=2",
        "https://m.kyochon.com/menu/menu_view?product_id=39242&depth1=7",
        "https://m.kyochon.com/menu/menu_view?product_id=39270&depth1=2"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val random = Random.nextInt(5)
        val loginId = intent.getStringExtra("SignIn")
        val name = intent.getStringExtra("name")
        val chicken = intent.getStringExtra("chicken")
        val tv = findViewById<TextView>(R.id.tv_info)
        val btn = findViewById<Button>(R.id.btn_chicken)
        val switch = findViewById<Switch>(R.id.sw_btnChange)
        tv.text = "아이디 : $loginId \n\n" +
                "이름 : ${name ?: "공명선"}\n\n" +
                "나이 : 23\n\n" +
                "좋아하는 치킨: ${chicken ?: "후라이드"}"
        val iv = findViewById<ImageView>(R.id.iv_chicken)
        Log.e("randomValue", "$random")
        iv.setImageResource(imageResources[random])
        btn.setOnClickListener {
            finish()
        }
        switch.setOnCheckedChangeListener { button, isChecked ->
            if(isChecked) {
                btn.text = "치킨 사먹으러 바로 고고"
                button.text = "종료로 바꾸기"
                btn.setOnClickListener {
                    val intentUri = Intent(Intent.ACTION_VIEW, Uri.parse(urlResources[random]))
                    startActivity(intentUri)
                }
            }
            else {
                btn.text = "종료"
                button.text = "링크로 바꾸기"
                btn.setOnClickListener {
                    finish()
                }
            }
        }
    }
}