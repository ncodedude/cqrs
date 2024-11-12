package com.example.cqrs.domain.order.core

import jakarta.persistence.*

@Entity
@Table(name = "orders")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val customer: String,
    val price: Double,
    val items: Int)    {

}