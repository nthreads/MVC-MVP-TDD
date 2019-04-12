package com.nthreads.mvp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import java.util.regex.Matcher

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btnSignIn.setOnClickListener(mClickListener)


    }

    private var mClickListener : View.OnClickListener = View.OnClickListener {


        val email = etEmail.text.toString()

        if(email.isEmpty()) {
            setError(etEmail, getString(R.string.error_field_required))
            return@OnClickListener
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            setError(etEmail, getString(R.string.error_invalid_email))
            return@OnClickListener
        }

        val password = etPassword.text.toString()

        if(password.isEmpty()) {
            setError(etPassword, getString(R.string.error_field_required))
            return@OnClickListener
        }

        val loginService = LoginService()

        if(loginService.authenticate(email, password)) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, getString(R.string.error_incorrect_email_password), Toast.LENGTH_LONG).show()
        }
    }

    private fun setError(input : EditText, errorMessage : String) {
        input.error = errorMessage
        input.requestFocus()
    }



}
