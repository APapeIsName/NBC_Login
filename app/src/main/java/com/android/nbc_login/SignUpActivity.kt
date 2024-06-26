package com.android.nbc_login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnSignUp = findViewById<Button>(R.id.btn_signup)
        val etName = findViewById<EditText>(R.id.et_name)
        val etId = findViewById<EditText>(R.id.et_signUpId)
        val etPwd = findViewById<EditText>(R.id.et_signUpPwd)
        val etChicken = findViewById<EditText>(R.id.et_singUpChicken)

        btnSignUp.setOnClickListener {
            if (
                etName.text.toString().isEmpty() ||
                etId.text.toString().isEmpty() ||
                etPwd.text.toString().isEmpty() ||
                etChicken.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("name", etName.text.toString())
                intent.putExtra("id", etId.text.toString())
                intent.putExtra("pwd", etPwd.text.toString())
                intent.putExtra("chicken", etChicken.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}