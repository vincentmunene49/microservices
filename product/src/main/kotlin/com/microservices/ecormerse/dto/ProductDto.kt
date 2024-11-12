package com.microservices.ecormerse.dto

data class ProductDto(
    var productId:Long?=null,
    var productName: String? = null,
    var productPrice: Double? = null,
    var quantity: Long? = null
) {
}