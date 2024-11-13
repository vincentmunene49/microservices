package com.microservices.orderservice.exception

import org.springframework.http.HttpStatus

class ProductException(message: String) : RuntimeException(message) {
}