package com.example.cqrs.domain.order.core

data class OrderDTO(val id: Long,
                    val customer: String,
                    val price: Double,
                    val items: Int){
    constructor(order:Order): this(
        id = order.id,
        customer = order.customer,
        price = order.price,
        items = order.items
    )
}
