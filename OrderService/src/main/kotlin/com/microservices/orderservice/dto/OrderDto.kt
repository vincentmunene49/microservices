package com.microservices.orderservice.dto

data class OrderDto(
    val productId: Long? = null,
    val quantity: Long? = null,
    val amount: Double? = null,
    val date: Long? = null,
    val orderStatus: String? = null
)
