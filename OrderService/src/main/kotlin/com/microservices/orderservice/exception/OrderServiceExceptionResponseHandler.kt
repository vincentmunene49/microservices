package com.microservices.orderservice.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class OrderServiceExceptionResponseHandler {

    @ResponseBody
    @ExceptionHandler(OrderNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleOrderNotFoundException(ex: OrderNotFoundException): ErrorMessage {
        return ErrorMessage(ex.message, HttpStatus.NOT_FOUND)
    }
}