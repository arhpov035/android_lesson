package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android.constance.Constance
import com.example.android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding
    val a = 324
    val b = 34
    var resultValue = ""

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.btYes.setOnClickListener{

            resultValue = bindingClass.textShow.text.toString()

            when(resultValue){
                in "Хоченьш я угаданю сколько тебе лет?" ->{
                    bYes("Тебе 8 лет")

                }
                in "Хочешь я угадаю, как тебя зовут?" ->{
                    val tempText = "Тебя зовут ${Constance.NAME_SYN}"
                    bYes(tempText)
                }
                in "Хочешь я угодаю, как зовут твою маму?" ->{
                    bYes("Твою маму зовут Анна. Она любит покушать.")
                }
                in "Хочешь я угодаю, как зовут твого папу?" ->{
                    bYes("Твоего папу зовут Виталий. У него спортивное телосложение.")
                }
                in "Хочешь я угодаю, в каком классе ты учишся?" ->{
                    bYes("Ты учишься в первом классе через дорогу от школы")
                    bindingClass.btNext.visibility = View.GONE
                }
            }
        }

        bindingClass.btNext.setOnClickListener{
            when(resultValue){
                in "Тебе 8 лет" ->{
                    bNext("Хочешь я угадаю, как тебя зовут?")
                }
                in "Тебя зовут Витя Архипов" ->{
                    bNext("Хочешь я угодаю, как зовут твою маму?")
                }
                in "Твою маму зовут Анна. Она любит покушать." ->{
                    bNext("Хочешь я угодаю, как зовут твого папу?")
                }
                in "Твоего папу зовут Виталий. У него спортивное телосложение." ->{
                    bNext("Хочешь я угодаю, в каком классе ты учишся?")
                }
            }
        }

    }

    fun bYes(result:String){
        resultValue = result
        bindingClass.textShow.text = resultValue
        bindingClass.btYes.visibility = View.GONE
        bindingClass.btNo.visibility = View.GONE
        bindingClass.btNext.visibility = View.VISIBLE
    }
    fun bNext(result:String){
        resultValue = result
        bindingClass.textShow.text = resultValue
        bindingClass.btNext.visibility = View.GONE
        bindingClass.btYes.visibility = View.VISIBLE
        bindingClass.btNo.visibility = View.VISIBLE
    }
}