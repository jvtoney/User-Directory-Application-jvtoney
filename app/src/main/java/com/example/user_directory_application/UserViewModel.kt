package com.example.user_directory_application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.example.user_directory_application.UserModels.User
sealed class UserUiState {
    object Loading : UserUiState()
    data class Success(val users: List<User>) : UserUiState()
    data class Error(val message: String) : UserUiState()
}

class UserViewModel : ViewModel() {
    private val _uiState = mutableStateOf<UserUiState>(UserUiState.Loading)
    val uiState: State<UserUiState> = _uiState

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _uiState.value = UserUiState.Loading
            try {
                val response = NetworkModule.api.getUsers(limit = 20)
                val users = response.users.map { dto ->
                    User(
                        id = dto.id,
                        fullName = "${dto.firstName} ${dto.lastName}",
                        email = dto.email,
                        imageUrl = dto.image
                    )
                }
                _uiState.value = UserUiState.Success(users)
            } catch (e: Exception) {
                _uiState.value = UserUiState.Error(
                    e.message ?: "Unknown error occurred"
                )
            }
        }
    }

}