package com.microservices.ecormerse.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
class ProductServiceResponseErrorHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundErrorHandler::class)
    fun productNotFoundHandler(productNotFoundErrorHandler: ProductNotFoundErrorHandler): ErrorMessage{
        return ErrorMessage(
            statusCode = HttpStatus.NOT_FOUND,
            message = productNotFoundErrorHandler.message
        )
    }
}