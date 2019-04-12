package com.nthreads.mvp.login

import android.support.annotation.StringRes

/**
 * Package Name : com.nthreads.mvp.login
 * Created by Muhammad Nauman Zubair on 4/13/19 - 2:36 AM.
 */
class LoginContract {

    interface View {
        fun getEmail() : String
        fun showEmptyEmailError(@StringRes resId : Int)
        fun showInvalidEmailError(@StringRes restId: Int)

        fun getPassword(): String
        fun showEmptyPasswordError(@StringRes resId: Int)
        fun startMainActivity()
        fun showInvalidLoginError()
    }
}