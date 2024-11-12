package com.example.cqrs.domain.order.application.command


import com.example.cqrs.domain.order.application.command.create.CreateOrderCommandHandler
import com.example.cqrs.domain.order.application.command.update.UpdateOrderCommandHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OrderCommandConfiguration {
    @Bean
    fun CreateOrderCommandHandlerBean(): CreateOrderCommandHandler  {
        return CreateOrderCommandHandler()
    }

    @Bean
    fun UpdateOrderCommandHandlerBean(): UpdateOrderCommandHandler  {
        return UpdateOrderCommandHandler()
    }
}