package com.example.cqrs.adapter.`in`.rest.request.payment

import com.example.cqrs.domain.payment.application.command.SendPaymentCommand

data class SendPaymentRequest(val orderId: Long, val creditCardNumber: String){
    fun toCommand(): SendPaymentCommand {
        return SendPaymentCommand(orderId, creditCardNumber)
    }
}
