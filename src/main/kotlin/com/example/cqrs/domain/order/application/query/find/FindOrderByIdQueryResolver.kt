package com.example.cqrs.domain.order.application.query.find

import com.example.cqrs.adapter.out.persistence.OrderRepository
import com.example.cqrs.common.application.query.AbstractQueryResolver
import com.example.cqrs.common.application.query.ApplicationQuery
import com.example.cqrs.domain.order.core.Order
import com.example.cqrs.domain.order.core.OrderDTO
import org.springframework.beans.factory.annotation.Autowired

class FindOrderByIdQueryResolver: AbstractQueryResolver<Order>() {
    @Autowired
    lateinit var orderRepository: OrderRepository

    override fun resolveQuery(query: ApplicationQuery<Order>?): Any {
        val query = (query as FindOrderByIdQuery)
        val order = orderRepository.findById(query.id)
        return OrderDTO(order.get())
    }
}