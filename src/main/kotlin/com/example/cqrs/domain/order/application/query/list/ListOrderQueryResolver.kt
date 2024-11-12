package com.example.cqrs.domain.order.application.query.list

import com.example.cqrs.adapter.out.persistence.OrderRepository
import com.example.cqrs.common.application.query.AbstractQueryResolver
import com.example.cqrs.common.application.query.ApplicationQuery
import com.example.cqrs.domain.order.core.Order
import com.example.cqrs.domain.order.core.OrderDTO
import org.springframework.beans.factory.annotation.Autowired

class ListOrderQueryResolver: AbstractQueryResolver<Order>() {

    @Autowired
    lateinit var orderRepository: OrderRepository

    override fun resolveQuery(query: ApplicationQuery<Order>?): Any {
        val orders = orderRepository.findAll().map { OrderDTO(it) }
        return orders;
    }
}