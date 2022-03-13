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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK && data != null){

            bindingClass.textView3.text = data.getStringExtra("key2")

        }
    }

    fun onClickTest1(view: View){
        val i = Intent(this, TestActivity::class.java)
        i.putExtra("key", "Как тебя зовут?")
        startActivityForResult(i, 100)
    }
}