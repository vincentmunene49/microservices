package com.microservices.ecormerse.exception

import org.springframework.http.HttpStatus

data class ErrorMessage(
    val message: String?,
    val statusCode: HttpStatus?
) {
}