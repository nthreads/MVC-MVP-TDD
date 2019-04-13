package com.nthreads.mvp.login

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

/**
 * Package Name : com.nthreads.mvp.login
 * Created by Muhammad Nauman Zubair on 4/13/19 - 4:48 AM.
 */
class LoginServiceTest {

    private lateinit var mLoginService: LoginService

    @Before
    fun setUp() {
        mLoginService = LoginService()
    }

    @Test
    fun whenAuthenticatedFailure_ReturnsFalse() {
        assert(!mLoginService.authenticate("nauman@gmail.om", "abc123"))
    }

    @Test
    fun whenAuthenticatedSuccess_ReturnsTrue() {
        assert(mLoginService.authenticate("nauman@gmail.com", "abc123"))
    }
}