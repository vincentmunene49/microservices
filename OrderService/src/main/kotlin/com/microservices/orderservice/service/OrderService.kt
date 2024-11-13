package com.microservices.orderservice.service

import com.microservices.orderservice.dto.OrderDto

interface OrderService {
    fun createOrder(orderDto: OrderDto): OrderDto
    fun getOrder(orderId: Long): OrderDto
    fun updateOrder(id:Long,orderDto: OrderDto): OrderDto
    fun deleteOrder(orderId: Long)
    fun getAllOrders(): List<OrderDto>
}