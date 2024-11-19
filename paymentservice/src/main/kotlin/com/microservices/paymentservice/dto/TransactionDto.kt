package com.microservices.paymentservice.dto

data class TransactionDto(
    val orderId: Long? = null,
    val paymentMode: String? = null,
    val referenceNo: String? = null,
    val paymentAmount: Double? = null
)
