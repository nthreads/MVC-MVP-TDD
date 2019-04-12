package com.nthreads.mvp

class LoginService {
    private val EMAIL : String = "nauman@gmail.com"
    private val PASSWORD : String = "abc123"

    fun authenticate(email: String, password: String): Boolean {
        return EMAIL == email && PASSWORD == password
    }

}
