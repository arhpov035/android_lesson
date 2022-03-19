package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.example.android.constance.Constance
//import com.example.android.constance.Constance
import com.example.android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding
    private var login: String = "empty"
    private var password: String = "empty"
    private var name: String = "empty"
    private var surname: String = "empty"
    private var middle_name: String = "empty"
    private var avatarImageId: Int = 0

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constance.REQUEST_CODE_SIGN_IN){
            val l = data?.getStringExtra(Constance.LOGIN) // вопрос означае если не равен NULL
            val p = data?.getStringExtra(Constance.PASSWORD)
            if (login == l && password == p){
                bindingClass.imageView.visibility = View.VISIBLE
                bindingClass.imageView.setImageResource(avatarImageId)
                val textInfo = "$name $surname $middle_name"
                bindingClass.tvinfo.text = textInfo
                bindingClass.bHide.visibility = View.GONE
                bindingClass.bExit.text = "Выйти"
            }else{
                bindingClass.imageView.visibility = View.VISIBLE
                bindingClass.imageView.setImageResource(R.drawable.scale_1200)
                bindingClass.tvinfo.text = "Такого аккаунта не существует"
            }

        } else if (requestCode == Constance.REQUEST_CODE_SIGN_UP){
            login = data?.getStringExtra(Constance.LOGIN)!! // восклицательный знак, может быть, а может и не быть
            password = data?.getStringExtra(Constance.PASSWORD)!!
            name = data?.getStringExtra(Constance.NAME)!!
            surname = data?.getStringExtra(Constance.SURNAME)!!
            middle_name = data?.getStringExtra(Constance.MIDDLE_NAME)!!
            avatarImageId = data?.getIntExtra(Constance.AVATAR_ID, 0)!! // у типа инт должно быть занчение по умолчанию
            bindingClass.imageView.visibility = View.VISIBLE
            bindingClass.imageView.setImageResource(avatarImageId)
            val textInfo = "$name $surname $middle_name"
            bindingClass.tvinfo.text = textInfo
            bindingClass.bHide.visibility = View.GONE
            bindingClass.bExit.text = "Выйти"
        }
    }

    fun onClickSignIn(view: View){
        if(bindingClass.imageView.isVisible && bindingClass.tvinfo.text != "Такого аккаунта не существует"){
            bindingClass.imageView.visibility = View.INVISIBLE
            bindingClass.tvinfo.text = ""

            bindingClass.bHide.visibility = View.VISIBLE
            bindingClass.bExit.text = getString(R.string.sign_in)
        }else{
            val intent = Intent(this, SignInUpAct::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN_STATE)
            startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_IN)
        }

    }

    fun onClickSignUp(view: View){
        val intent = Intent(this, SignInUpAct::class.java)
        intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP_STATE)
        startActivityForResult(intent, Constance.REQUEST_CODE_SIGN_UP)
    }
}