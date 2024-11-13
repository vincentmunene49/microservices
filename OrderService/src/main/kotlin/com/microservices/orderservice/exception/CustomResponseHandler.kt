package com.microservices.orderservice.exception

import com.microservices.orderservice.error_decoder.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class CustomResponseHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ProductException::class)
    fun productNotFoundHandler(customExceptionHandler: ProductException): ErrorResponse {
        return ErrorResponse(
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR,
            message = customExceptionHandler.message
        )
    }
}