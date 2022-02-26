package com.example.android

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

        bindingClass.btResult.setOnClickListener{

            Log.d("MyLog", "ID egor = ${R.drawable.egor}")

            val resultValue = bindingClass.tvName.text.toString()
            bindingClass.imPhoto.visibility = View.VISIBLE

            when(resultValue){
                Constance.DIRECTOR -> {
                    bindingClass.tvResult.visibility = View.VISIBLE

                    val tempText = "Получите Ваши ${Constance.DIRECTOR_SUELDO}"
                    if (bindingClass.edPassword.text.toString() == Constance.DIRECTOR_PASSWORD){
                        bindingClass.tvResult.text = tempText
                        bindingClass.imPhoto.setImageResource(R.drawable.egor)
                    }else{
                        bindingClass.tvResult.text = "Неверный пароль"
                    }
                }

                Constance.INGINER -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    val tempText = "Получите Ваши ${Constance.INGINER_SUELDO}"
                    if (bindingClass.edPassword.text.toString() == Constance.INGINER_PASSWORD){
                        bindingClass.tvResult.text = tempText
                        bindingClass.imPhoto.setImageResource(R.drawable.andrey)
                    }else{
                        bindingClass.tvResult.text = "Неверный пароль"
                    }
                }

                Constance.DVORNIK -> {
                    bindingClass.tvResult.visibility = View.VISIBLE
                    val tempText = "Получите Ваши ${Constance.DVORNIK_SUELDO}"
                    if (bindingClass.edPassword.text.toString() == Constance.DVORNIK_PASSWORD){
                        bindingClass.tvResult.text = tempText
                        bindingClass.imPhoto.setImageResource(R.drawable.sergey)
                    }else{
                        bindingClass.tvResult.text = "Неверный пароль"
                    }
                }
            }


        }

    }

}