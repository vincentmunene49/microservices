package com.microservices.ecormerse.service

import com.microservices.ecormerse.dto.ProductDto

interface ProductService {

    fun createProduct(productDto: ProductDto): ProductDto

    fun updateProduct(id: Long, productDto: ProductDto): ProductDto

    fun deleteProductById(id: Long)

    fun getProductById(id: Long): ProductDto

    fun getAllProducts(): List<ProductDto>
}