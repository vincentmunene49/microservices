package com.microservices.ecormerse.service.impl

import com.microservices.ecormerse.dto.ProductDto
import com.microservices.ecormerse.exception.GenericErrorHandler
import com.microservices.ecormerse.exception.ProductNotFoundErrorHandler
import com.microservices.ecormerse.model.Product
import com.microservices.ecormerse.repository.ProductRepository
import com.microservices.ecormerse.service.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository
) : ProductService {
    override fun createProduct(productDto: ProductDto): ProductDto {
        val product = Product(
            productName = productDto.productName,
            productPrice = productDto.productPrice,
            quantity = productDto.quantity
        )
        productRepository.save(product)
        return ProductDto(
            productId = product.productId,
            productName = product.productName,
            productPrice = product.productPrice,
            quantity = product.quantity
        )
    }

    override fun updateProduct(id: Long, productDto: ProductDto): ProductDto {
        val existingProduct = productRepository.findById(id).orElseThrow {
            throw ProductNotFoundErrorHandler("Product with id $id not found")
        }
        existingProduct.apply {
            productName = productDto.productName
            productPrice = productDto.productPrice
            quantity = productDto.quantity

        }

        productRepository.save(existingProduct)

        return ProductDto(
            productId = existingProduct.productId,
            productName = existingProduct.productName,
            productPrice = existingProduct.productPrice,
            quantity = existingProduct.quantity
        )
    }

    override fun deleteProductById(id: Long) {
        val existingProduct = productRepository.findById(id).orElseThrow {
            throw ProductNotFoundErrorHandler("Product with id $id not found")
        }
        productRepository.delete(existingProduct)
    }

    override fun getProductById(id: Long): ProductDto {
        return productRepository.findById(id).map {
            ProductDto(
                productId = it.productId,
                productName = it.productName,
                productPrice = it.productPrice,
                quantity = it.quantity
            )
        }.orElseThrow {
            throw ProductNotFoundErrorHandler("Product with id $id not found")
        }
    }

    override fun getAllProducts(): List<ProductDto> {
        return productRepository.findAll().map {
            ProductDto(
                productId = it.productId,
                productName = it.productName,
                productPrice = it.productPrice,
                quantity = it.quantity
            )
        }
    }

    override fun reduceProductQuantity(productId: Long, quantity: Long): ProductDto {
        val product = productRepository.findById(productId).orElseThrow {
            throw ProductNotFoundErrorHandler("Product with id $productId not found")
        }
        if(quantity <= 0) {
            throw GenericErrorHandler("Quantity should be greater than 0")
        }
        if (product.quantity!! < quantity) {
            throw GenericErrorHandler("Insufficient Stock to match your request")
        }

        product.quantity = product.quantity?.minus(quantity)
        productRepository.save(product)
        return ProductDto(
            productId = product.productId,
            productName = product.productName,
            productPrice = product.productPrice,
            quantity = product.quantity
        )
    }
}