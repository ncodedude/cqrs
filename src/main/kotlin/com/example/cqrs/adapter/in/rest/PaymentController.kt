package com.example.cqrs.adapter.`in`.rest

import com.example.cqrs.adapter.`in`.rest.request.payment.SendPaymentRequest
import com.example.cqrs.adapter.`in`.rest.response.payment.SendPaymentResponse
import com.example.cqrs.common.application.ApplicationDispatcherContextInterface
import com.example.cqrs.domain.invoice.application.event.IssueInvoiceEvent
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController()
@RequestMapping("api/v1/payment")
class PaymentController(private val applicationDispatcher: ApplicationDispatcherContextInterface)
{
    @PostMapping()
    fun sendPayment(@RequestBody sendPaymentRequest: SendPaymentRequest): SendPaymentResponse {
        val  command =  sendPaymentRequest.toCommand()
        val response = this.applicationDispatcher.execute(command) as Long;
        this.applicationDispatcher.execute(IssueInvoiceEvent(command.orderId))
        return SendPaymentResponse(response)
    }
}