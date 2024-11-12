package com.example.cqrs.domain.invoice.core

import jakarta.persistence.*

@Entity
@Table(name = "invoices")
class Invoice(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val orderId: Long,
    val wasRequested: Boolean,
    val invoiceUrl: String
)