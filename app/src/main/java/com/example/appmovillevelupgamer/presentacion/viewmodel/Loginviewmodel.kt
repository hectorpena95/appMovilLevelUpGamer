package com.example.appmovillevelupgamer.presentacion.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess: StateFlow<Boolean> = _loginSuccess

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading


    fun onEmailChange(value: String) {
        _email.value = value
    }

    fun onPasswordChange(value: String) {
        _password.value = value
    }

    fun login() {
        viewModelScope.launch {

            _loading.value = true

            // Simulamos llamada a backend
            delay(1500)

            // Ejemplo simple: validar correo y contraseña
            _loginSuccess.value =
                (_email.value == "admin@levelup.com" &&
                        _password.value == "123456")

            _loading.value = false
        }
    }
}

