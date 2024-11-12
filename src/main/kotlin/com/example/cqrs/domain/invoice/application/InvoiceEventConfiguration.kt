package com.example.cqrs.domain.invoice.application

import com.example.cqrs.domain.invoice.application.event.IssueInvoiceEventListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InvoiceEventConfiguration {
    @Bean
    fun IssueInvoiceEventListenerBean(): IssueInvoiceEventListener{
        return  IssueInvoiceEventListener()
    }
}