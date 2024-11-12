package com.example.cqrs.adapter.out.persistence

import com.example.cqrs.domain.invoice.core.Invoice
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
interface InvoiceRepository: CrudRepository<Invoice, Long> {
}