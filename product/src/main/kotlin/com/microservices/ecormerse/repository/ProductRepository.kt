package com.microservices.ecormerse.repository

import com.microservices.ecormerse.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository:JpaRepository<Product,Long> {
}