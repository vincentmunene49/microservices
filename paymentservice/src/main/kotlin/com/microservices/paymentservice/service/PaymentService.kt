package com.microservices.paymentservice.service

import com.microservices.paymentservice.dto.TransactionDto

interface PaymentService {

    fun processAndSavePayment(transactionDetailsDto: TransactionDto):TransactionDto
}