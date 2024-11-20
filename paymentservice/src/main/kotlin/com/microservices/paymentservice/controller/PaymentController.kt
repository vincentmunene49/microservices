package com.microservices.paymentservice.controller

import com.microservices.paymentservice.dto.TransactionDto
import com.microservices.paymentservice.service.PaymentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/payment")
class PaymentController(
    private val paymentService: PaymentService
) {
    @PostMapping
    fun processPayment(
        @RequestBody transactionDetailsDto: TransactionDto
    ): ResponseEntity<TransactionDto> {
        val response = paymentService.processAndSavePayment(transactionDetailsDto)
        return ResponseEntity.ok(response)
    }

    @GetMapping
    fun getAllTransactions(): ResponseEntity<List<TransactionDto>> {
        return ResponseEntity.ok(paymentService.getAllTransactions())
    }
}