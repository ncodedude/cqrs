package com.example.cqrs.adapter.`in`.rest.request.order

import com.example.cqrs.domain.order.application.command.create.CreateOrderCommand

data class CreateOrderRequest(val price: Double, val customer: String, val items: Int){
    fun toCommand(): CreateOrderCommand {
        return CreateOrderCommand(price, customer, items)
    }
}
