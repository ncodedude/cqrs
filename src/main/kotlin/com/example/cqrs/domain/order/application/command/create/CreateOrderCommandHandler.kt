package com.example.cqrs.domain.order.application.command.create

import com.example.cqrs.adapter.out.persistence.OrderRepository
import com.example.cqrs.common.application.command.AbstractCommandHandler
import com.example.cqrs.common.application.command.ApplicationCommand
import com.example.cqrs.domain.order.core.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

class CreateOrderCommandHandler(): AbstractCommandHandler<Order>() {

    @Autowired
    lateinit var orderRepository: OrderRepository

    override fun handleCommand(command: ApplicationCommand<Order>?): Long {
        val order = (command as CreateOrderCommand)

        val entity = this.orderRepository.save(order.toEntity())
        return entity.id
    }
}