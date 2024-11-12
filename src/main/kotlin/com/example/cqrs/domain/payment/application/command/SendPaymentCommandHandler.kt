package com.example.cqrs.domain.payment.application.command

import com.example.cqrs.adapter.out.persistence.PaymentRepository
import com.example.cqrs.common.application.command.AbstractCommandHandler
import com.example.cqrs.common.application.command.ApplicationCommand
import com.example.cqrs.domain.payment.core.Payment
import org.springframework.beans.factory.annotation.Autowired

class SendPaymentCommandHandler: AbstractCommandHandler<Payment>() {

    @Autowired
    lateinit var paymentRepository: PaymentRepository

    override fun handleCommand(command: ApplicationCommand<Payment>?): Long {
        val payment = (command as SendPaymentCommand)
        return paymentRepository.save(command.toEntity()).id
    }

}