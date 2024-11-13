package com.microservices.orderservice.error_decoder.response

import org.springframework.http.HttpStatus

data class ErrorResponse(
    val message: String? = null,
    val statusCode: HttpStatus? = null
) {
}