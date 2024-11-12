package com.microservices.ecormerse

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EcormerseApplication

fun main(args: Array<String>) {
	runApplication<EcormerseApplication>(*args)
}
