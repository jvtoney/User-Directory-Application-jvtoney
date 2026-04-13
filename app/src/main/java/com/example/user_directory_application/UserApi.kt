package com.example.user_directory_application

import retrofit2.http.GET
import retrofit2.http.Query
import com.example.user_directory_application.UserModels.UsersResponse
interface UserApi {
    @GET("users")
    suspend fun getUsers(@Query("limit") limit: Int = 20) : UsersResponse
}