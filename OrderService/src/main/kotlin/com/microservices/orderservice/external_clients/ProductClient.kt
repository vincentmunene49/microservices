package com.microservices.orderservice.external_clients

import com.microservices.orderservice.dto.ProductDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping

@FeignClient(name="product-service/products")
interface ProductClient {

    @PutMapping("/reduceQuantity/{productId}/{quantity}")
    fun reduceProductQuantity(@PathVariable productId: Long, @PathVariable quantity: Long): ProductDto
}