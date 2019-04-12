package com.nthreads.mvp.login

import android.util.Patterns
import android.widget.Toast
import com.nthreads.mvp.R

class LoginPresenter(val loginView: LoginContract.View, val loginService: LoginService) {


    fun onLoginClick() {
        val email = loginView.getEmail()

        if(email.isEmpty()) {
            loginView.showEmptyEmailError(R.string.error_field_required)
            return
        }

        if(!email.isValid()) {
            loginView.showInvalidEmailError(R.string.error_invalid_email)
            return
        }

        val password = loginView.getPassword()

        if(password.isEmpty()) {
            loginView.showEmptyPasswordError(R.string.error_field_required)
            return
        }

        if(loginService.authenticate(email, password)) {
            loginView.startMainActivity()
        } else {
            loginView.showInvalidLoginError()
        }

    }

    // Extension function
    private fun String.isValid() : Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

}
