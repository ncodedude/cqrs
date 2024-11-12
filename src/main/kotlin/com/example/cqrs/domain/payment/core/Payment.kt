package com.example.cqrs.domain.payment.core

import jakarta.persistence.*

@Entity
@Table(name = "payments")
class Payment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val orderId: Long,
    val creditCardNumber: String
)