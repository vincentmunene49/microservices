package com.microservices.paymentservice.repository

import com.microservices.paymentservice.model.TransactionDetails
import org.springframework.data.jpa.repository.JpaRepository


interface PaymentRepository: JpaRepository<TransactionDetails,Long>{
}