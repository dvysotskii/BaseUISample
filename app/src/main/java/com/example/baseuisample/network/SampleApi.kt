package com.example.baseuisample.network


import com.example.baseuisample.network.model.LoginRequest
import com.example.baseuisample.network.model.LoginResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface SampleApi {

    @POST("auth/login")
    fun authorizate(@Body data: LoginRequest): Observable<LoginResponse>
}