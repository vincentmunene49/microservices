package com.microservices.orderservice.controller

import com.microservices.orderservice.dto.OrderDto
import com.microservices.orderservice.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/order")
class OrderController(
    private val orderService: OrderService
) {

    @GetMapping
    fun findAllOrders(): ResponseEntity<List<OrderDto>> {
        return ResponseEntity.ok(orderService.getAllOrders())
    }

    @GetMapping("/{orderId}")
    fun findOrderById(@PathVariable orderId: Long): ResponseEntity<OrderDto> {
        return ResponseEntity.ok(orderService.getOrder(orderId))
    }

    @PostMapping
    fun createOrder(@RequestBody orderDto: OrderDto): ResponseEntity<OrderDto> {
        return ResponseEntity.ok(orderService.createOrder(orderDto))
    }

    @DeleteMapping("/{orderId}")
    fun deleteOrder(@PathVariable orderId: Long): ResponseEntity<Unit> {
        orderService.deleteOrder(orderId)
        return ResponseEntity.noContent().build()
    }



}