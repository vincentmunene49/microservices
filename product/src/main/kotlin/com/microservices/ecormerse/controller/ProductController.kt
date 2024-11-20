package com.microservices.ecormerse.controller

import com.microservices.ecormerse.dto.ProductDto
import com.microservices.ecormerse.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping
    fun getAllProducts() : ResponseEntity<List<ProductDto>>{
        return ResponseEntity.ok(productService.getAllProducts())
    }

    @PostMapping
    fun createProduct(@RequestBody productDto: ProductDto): ResponseEntity<ProductDto>{
        return ResponseEntity.ok(productService.createProduct(productDto))
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long): ResponseEntity<ProductDto>{
        return ResponseEntity.ok(productService.getProductById(id))
    }

    @DeleteMapping("/{id}")
    fun deleteProductById(@PathVariable id: Long): ResponseEntity<Unit>{
        productService.deleteProductById(id)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/reduceQuantity/{productId}/{quantity}")
    fun reduceProductQuantity(@PathVariable productId: Long, @PathVariable quantity: Long): ResponseEntity<ProductDto>{
        return ResponseEntity.ok(productService.reduceProductQuantity(productId, quantity))
    }

}