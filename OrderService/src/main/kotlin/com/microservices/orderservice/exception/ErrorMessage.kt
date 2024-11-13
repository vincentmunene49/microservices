package com.microservices.orderservice.exception

import org.springframework.http.HttpStatus

data class ErrorMessage(
    val message: String? = null,
    val errorCode: HttpStatus? = null,
) {
}