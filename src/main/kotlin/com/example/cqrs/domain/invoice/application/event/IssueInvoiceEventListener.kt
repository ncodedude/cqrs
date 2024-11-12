package com.example.cqrs.domain.invoice.application.event

import com.example.cqrs.adapter.out.persistence.InvoiceRepository
import com.example.cqrs.adapter.out.topic.TopicInterface
import com.example.cqrs.common.application.event.AbstractEventListener
import com.example.cqrs.common.application.event.ApplicationEvent
import com.example.cqrs.domain.invoice.core.Invoice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

class IssueInvoiceEventListener: AbstractEventListener<Invoice>() {

    @Autowired
    lateinit var topicInterface: TopicInterface
    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    override fun consumeEvent(event: ApplicationEvent<Invoice>?): Boolean {
        val event = (event as IssueInvoiceEvent)
        invoiceRepository.save(Invoice(0, event.orderId, true, ""))
        return topicInterface.sendMessageToTopic(event.orderId.toString(),"invoices-topic")
    }
}