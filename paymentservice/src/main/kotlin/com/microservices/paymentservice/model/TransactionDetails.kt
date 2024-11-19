package com.microservices.paymentservice.model

import jakarta.persistence.*


@Entity
@Table(name = "transaction_details")
data class TransactionDetails(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "transaction_id_seq")
    @SequenceGenerator(name = "transaction_id_seq", sequenceName = "transaction_id_seq", allocationSize = 1)
    val transactionId: Long? = null,
    val orderId: Long? = null,
    val paymentStatus: String? = null,
    val paymentMode: String? = null,
    val date: Long? = null,
    val referenceNo: String? = null,
    val paymentAmount: Double? = null
)
