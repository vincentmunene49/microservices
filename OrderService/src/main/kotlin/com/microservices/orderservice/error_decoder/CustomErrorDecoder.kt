package com.microservices.orderservice.error_decoder

import com.fasterxml.jackson.databind.ObjectMapper
import com.microservices.orderservice.error_decoder.response.ErrorResponse
import com.microservices.orderservice.exception.ProductException
import feign.Response
import feign.codec.ErrorDecoder

class CustomErrorDecoder:ErrorDecoder {

    override fun decode(message: String?, response: Response?): Exception {
        log.info(response?.request()?.url())
        log.info(response?.request()?.headers().toString())

        val errorMessage = ObjectMapper().readValue(response?.body()?.asInputStream(), ErrorResponse::class.java)

        return ProductException(errorMessage.message!!)
    }

    companion object{
        val log = org.slf4j.LoggerFactory.getLogger(CustomErrorDecoder::class.java)
    }
}