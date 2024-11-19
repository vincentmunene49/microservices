package com.microservices.orderservice.external_clients

import com.microservices.orderservice.dto.TransactionDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "paymentservice/payment")
interface PaymentClient {
    @PostMapping
    fun processPayment(
        @RequestBody transactionDetailsDto: TransactionDto
    )
}