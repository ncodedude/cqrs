package com.example.cqrs.domain.payment.application.command

import com.example.cqrs.common.application.command.ApplicationCommand
import com.example.cqrs.domain.payment.core.Payment

class SendPaymentCommand(val orderId: Long, val creditCardNumber: String):ApplicationCommand<Payment> {
    fun toEntity(): Payment {
        return Payment(0,  orderId,  creditCardNumber)
    }
}