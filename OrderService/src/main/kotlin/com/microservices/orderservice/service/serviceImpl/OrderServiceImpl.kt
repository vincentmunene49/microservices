package com.microservices.orderservice.service.serviceImpl

import com.microservices.orderservice.dto.OrderDto
import com.microservices.orderservice.dto.TransactionDto
import com.microservices.orderservice.exception.OrderNotFoundException
import com.microservices.orderservice.external_clients.PaymentClient
import com.microservices.orderservice.external_clients.ProductClient
import com.microservices.orderservice.model.Order
import com.microservices.orderservice.repository.OrderRepository
import com.microservices.orderservice.service.OrderService
import org.joda.time.DateTime
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val productClient: ProductClient,
    private val paymentClient: PaymentClient
) : OrderService {
    override fun createOrder(orderDto: OrderDto): OrderDto {
        val orderEntity = Order(
            productId = orderDto.productId,
            quantity = orderDto.quantity,
            amount = orderDto.amount,
            date = DateTime.now().millis,
            orderStatus ="CREATED"
        )
        productClient.reduceProductQuantity(orderEntity.productId!!, orderEntity.quantity!!)
        val savedOrder = orderRepository.save(orderEntity)
        val transactionDetails = TransactionDto(
            orderId = orderEntity.id,
            paymentMode = "CASH",
            referenceNo = "123456",
            paymentAmount = orderEntity.amount
        )
        var orderStatus = ""
        try{
            paymentClient.processPayment(transactionDetails)
            orderStatus = "PLACED"
        }catch (e:Exception){
            orderStatus = "PAYMENT_FAILED"
        }
        orderEntity.orderStatus = orderStatus
        orderRepository.save(orderEntity)
        return OrderDto(
            productId = savedOrder.productId,
            quantity = savedOrder.quantity,
            amount = savedOrder.amount,
            date = savedOrder.date,
            orderStatus = savedOrder.orderStatus
        )
    }

    override fun getOrder(orderId: Long): OrderDto {
        return orderRepository.findById(orderId).map {
            OrderDto(
                productId = it.productId,
                quantity = it.quantity,
                amount = it.amount,
                date = it.date,
                orderStatus = it.orderStatus
            )
        }.orElseThrow {
            throw OrderNotFoundException("Order not found")
        }

    }

    override fun updateOrder(id: Long, orderDto: OrderDto): OrderDto {
        val orderEntity = orderRepository.findById(id).orElseThrow { throw OrderNotFoundException("Order not found") }
        orderDto.apply {
            orderEntity.productId = this.productId
            orderEntity.quantity = this.quantity
            orderEntity.amount = this.amount
            orderEntity.date = this.date
            orderEntity.orderStatus = this.orderStatus
        }
        val updatedOrder = orderRepository.save(orderEntity)
        return OrderDto(
            productId = updatedOrder.productId,
            quantity = updatedOrder.quantity,
            amount = updatedOrder.amount,
            date = updatedOrder.date,
            orderStatus = updatedOrder.orderStatus
        )
    }

    override fun deleteOrder(orderId: Long) {
        val orderEntity = orderRepository.findById(orderId).orElseThrow { throw OrderNotFoundException("Order not found") }
        orderRepository.delete(orderEntity)
    }

    override fun getAllOrders(): List<OrderDto> {

        return orderRepository.findAll().map {
            OrderDto(
                productId = it.productId,
                quantity = it.quantity,
                amount = it.amount,
                date = it.date,
                orderStatus = it.orderStatus
            )
        }

    }
}