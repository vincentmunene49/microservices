package com.microservices.orderservice.model

import jakarta.persistence.*

@Entity
@Table(name = "order_table")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_seq")
    @SequenceGenerator(name = "order_id_seq", sequenceName = "order_id_seq", allocationSize = 1, initialValue = 1)
    val id: Long? = null,
    var productId: Long? = null,
    var quantity: Long? = null,
    var amount: Double? = null,
    var date: Long? = null,
    var orderStatus: String? = null

) {
}