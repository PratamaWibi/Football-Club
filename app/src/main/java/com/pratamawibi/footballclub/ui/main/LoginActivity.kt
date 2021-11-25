package com.pratamawibi.footballclub.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import com.pratamawibi.footballclub.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener { login() }
    }

    fun login(){
        var email = findViewById(R.id.inputEmail) as EditText
        if(isValidCredential(email.text.toString(),inputPassword.text.toString())){
            Snackbar.make(btnLogin,"Success Login",Snackbar.LENGTH_LONG)
                    .setAction("Action",null).show()
            val intent = Intent (this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            Snackbar.make(btnLogin,"Invalid Credential",Snackbar.LENGTH_LONG)
                    .setAction("Action",null).show()
        }
    }
    fun isValidCredential(email: String, password:String): Boolean{
        return (email == "pratamawibi@tekkom.com" && password == "wibi1234")
    }
}