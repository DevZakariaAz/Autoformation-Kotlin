package com.example.lab_view_model.models

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("todos/1")
    fun getTodo(): Call<Todo>
}
