package com.example.cqrs.adapter.`in`.rest.request.order

import com.example.cqrs.domain.order.application.command.update.UpdateOrderCommand

data class UpdateOrderRequest( val price: Double, val customer: String, val items: Int){
    fun toCommand(id: Long): UpdateOrderCommand {
        return UpdateOrderCommand(id, price, customer, items)
    }
}