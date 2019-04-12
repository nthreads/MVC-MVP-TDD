package com.nthreads.mvp.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.nthreads.mvp.main.MainActivity
import com.nthreads.mvp.R
import kotlinx.android.synthetic.main.activity_login.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity(), LoginContract.View {



    private lateinit var loginPresenter : LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenter(this, LoginService())

        btnSignIn.setOnClickListener(mClickListener)

    }

    private var mClickListener : View.OnClickListener = View.OnClickListener {
        
        loginPresenter.onLoginClick()
    }

    override fun getEmail(): String {
        return etEmail.text.toString()
    }

    override fun showEmptyEmailError(resId: Int) {
        setError(etEmail, getString(R.string.error_field_required))
    }

    override fun showInvalidEmailError(restId: Int) {
        setError(etEmail, getString(R.string.error_invalid_email))
    }

    override fun getPassword(): String {
        return etPassword.text.toString()
    }

    override fun showEmptyPasswordError(resId: Int) {
        setError(etPassword, getString(R.string.error_field_required))
    }

    override fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun showInvalidLoginError() {
        Toast.makeText(this, getString(R.string.error_incorrect_email_password), Toast.LENGTH_LONG).show()
    }

    private fun setError(input : EditText, errorMessage : String) {
        input.error = errorMessage
        input.requestFocus()
    }



}
