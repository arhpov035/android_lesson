package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
//import com.example.android.constance.Constance
import com.example.android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding



    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.btYes.setOnClickListener {

//            var resultValue = bindingClass.edVa

//            when(resultValue){
//
//            }
        }

    }

}