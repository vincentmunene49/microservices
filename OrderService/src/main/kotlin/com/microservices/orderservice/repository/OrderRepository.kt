package com.microservices.orderservice.repository

import com.microservices.orderservice.model.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Long> {
}