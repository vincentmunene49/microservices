package com.microservices.paymentservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PaymentserviceApplication

fun main(args: Array<String>) {
	runApplication<PaymentserviceApplication>(*args)
}
