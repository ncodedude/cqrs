package com.example.cqrs.domain.invoice.application.event

import com.example.cqrs.common.application.event.ApplicationEvent
import com.example.cqrs.domain.invoice.core.Invoice

class IssueInvoiceEvent(val orderId: Long,):ApplicationEvent<Invoice> {
}