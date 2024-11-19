package com.microservices.paymentservice.service.impl

import com.microservices.paymentservice.dto.TransactionDto
import com.microservices.paymentservice.model.TransactionDetails
import com.microservices.paymentservice.repository.PaymentRepository
import com.microservices.paymentservice.service.PaymentService
import org.joda.time.DateTime
import org.springframework.stereotype.Service

@Service
class PaymentServiceImpl(
    private val paymentRepository: PaymentRepository
): PaymentService {
    override fun processAndSavePayment(transactionDetailsDto: TransactionDto): TransactionDto {
        val transactionDetails = TransactionDetails(
            orderId = transactionDetailsDto.orderId,
            paymentMode = transactionDetailsDto.paymentMode,
            referenceNo = transactionDetailsDto.referenceNo,
            paymentAmount = transactionDetailsDto.paymentAmount,
            paymentStatus = "SUCCESS",
            date = DateTime.now().millis
        )
        paymentRepository.save(transactionDetails)

        val savedTransaction = TransactionDto(
            orderId = transactionDetails.orderId,
            paymentMode = transactionDetails.paymentMode,
            referenceNo = transactionDetails.referenceNo,
            paymentAmount = transactionDetails.paymentAmount
        )
        return savedTransaction
    }


}