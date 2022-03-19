package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.android.constance.Constance
import com.example.android.databinding.ActivitySignUpInBinding

class SignInUpAct : AppCompatActivity() {
    lateinit var bindingClass: ActivitySignUpInBinding
    private var signState = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySignUpInBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        signState = intent.getStringExtra(Constance.SIGN_STATE)!! // восклицателный знак нужен для того, чтобы показать что здесь может быть NULL

        if (signState == Constance.SIGN_IN_STATE){
            bindingClass.edName.visibility = View.GONE
            bindingClass.edsurname.visibility = View.GONE
            bindingClass.edMiddleName.visibility = View.GONE
            bindingClass.bAvatar.visibility = View.INVISIBLE
        }
    }

    fun onClickDone(view: View){

        if (signState == Constance.SIGN_UP_STATE){
            val intent = Intent()
            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.text.toString())
            intent.putExtra(Constance.NAME, bindingClass.edName.text.toString())
            intent.putExtra(Constance.SURNAME, bindingClass.edsurname.text.toString())
            intent.putExtra(Constance.MIDDLE_NAME, bindingClass.edMiddleName.text.toString())
            if (bindingClass.imAvatar.isVisible)intent.putExtra(Constance.AVATAR_ID, R.drawable.andrey)
            setResult(RESULT_OK, intent)
            finish()
        } else if (signState == Constance.SIGN_IN_STATE){
            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }

    }

    fun onClickAvatar(view: View){
        bindingClass.imAvatar.visibility =  View.VISIBLE

    }
}