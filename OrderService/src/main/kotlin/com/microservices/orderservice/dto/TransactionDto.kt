package com.microservices.orderservice.dto

data class TransactionDto(
    val orderId: Long? = null,
    val paymentMode: String? = null,
    val referenceNo: String? = null,
    val paymentAmount: Double? = null
)
