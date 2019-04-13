package com.nthreads.mvp.login

import com.nthreads.mvp.R
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Package Name : com.nthreads.mvp.login
 * Created by Muhammad Nauman Zubair on 4/13/19 - 4:07 AM.
 */
class LoginPresenterTest {

    private lateinit var mLoginView: LoginContract.View
    private lateinit var mLoginService: LoginService

    private lateinit var mLoginPresenter: LoginPresenter

    @Before
    fun setUp() {

        mLoginView = Mockito.mock(LoginContract.View::class.java)
        mLoginService = Mockito.mock(LoginService::class.java)

        mLoginPresenter = LoginPresenter(mLoginView, mLoginService)
    }

    @Test
    fun whenEmailEmptyShowError() {
        Mockito.`when`(mLoginView.getEmail()).thenReturn("")
        mLoginPresenter.onLoginClick()

        Mockito.verify(mLoginView).showEmptyEmailError(R.string.error_field_required)
    }

    @Test
    fun whenPasswordEmptyShowError() {
        Mockito.`when`(mLoginView.getEmail()).thenReturn("nauman@gmail.com")
        Mockito.`when`(mLoginView.getPassword()).thenReturn("")
        mLoginPresenter.onLoginClick()

        Mockito.verify(mLoginView).showEmptyPasswordError(R.string.error_field_required)
    }

    @Test
    fun whenAuthenticatedSuccess() {
        Mockito.`when`(mLoginView.getEmail()).thenReturn("nauman@gmail.com")
        Mockito.`when`(mLoginView.getPassword()).thenReturn("abc123")

        Mockito.`when`(mLoginService.authenticate("nauman@gmail.com", "abc123")).thenReturn(true)

        mLoginPresenter.onLoginClick()

        Mockito.verify(mLoginView).startMainActivity()
    }
}