package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.android.constance.Constance
//import com.example.android.constance.Constance
import com.example.android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

    }

    fun onClickGoManually(view: View) {
        val intent = Intent(this, TestActivityManually::class.java)
        startActivity(intent)
    }

    fun onClickClose(view: View) {
        finish()
    }

}