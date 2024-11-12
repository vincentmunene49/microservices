package com.microservices.ecormerse.model

import jakarta.persistence.*

@Entity
@Table(name = "product_table")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product-seq")
    @SequenceGenerator(name = "product-seq", sequenceName = "product-seq", allocationSize = 1, initialValue = 1)
    val productId: Long? = null,
    var productName: String? = null,
    var productPrice: Double? = null,
    var quantity: Long? = null

) {
}