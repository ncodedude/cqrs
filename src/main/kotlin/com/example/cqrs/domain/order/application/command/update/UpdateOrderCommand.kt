package com.example.cqrs.domain.order.application.command.update

import com.example.cqrs.common.application.command.ApplicationCommand
import com.example.cqrs.domain.order.core.Order


class UpdateOrderCommand(private val id: Long, private val price: Double, private val customer: String, private val items: Int):
    ApplicationCommand<Order> {
        fun toEntity(): Order {
            return  Order(id, customer, price, items)
        }
}