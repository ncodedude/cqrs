package com.example.cqrs.domain.order.application.command.create

import com.example.cqrs.common.application.command.ApplicationCommand
import com.example.cqrs.domain.order.core.Order

class CreateOrderCommand(private val price: Double, private val customer: String, private val items: Int): ApplicationCommand<Order> {
    fun toEntity(): Order {
        return Order(0,customer, price,items)
    }
}