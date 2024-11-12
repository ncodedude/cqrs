package com.example.cqrs.domain.payment.application

import com.example.cqrs.domain.payment.application.command.SendPaymentCommandHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PaymentCommandConfiguration {
    @Bean
    fun SendPaymentCommandHandlerBean(): SendPaymentCommandHandler {
        return SendPaymentCommandHandler()
    }
}
