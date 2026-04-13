package com.example.user_directory_application

object UserModels {
    data class UsersResponse(
        val users: List<UserDto>
    )

    data class UserDto(
        val id: Int,
        val firstName: String,
        val lastName: String,
        val email: String,
        val image: String
    )

    data class User(
        val id: Int,
        val fullName: String,
        val email: String,
        val imageUrl: String
    )

}