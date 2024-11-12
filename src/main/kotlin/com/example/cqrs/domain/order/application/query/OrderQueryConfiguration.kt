package com.example.cqrs.domain.order.application.query

import com.example.cqrs.domain.order.application.query.find.FindOrderByIdQueryResolver
import com.example.cqrs.domain.order.application.query.list.ListOrderQueryResolver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OrderQueryConfiguration {
    @Bean
    fun ListOrderQueryResolverBean(): ListOrderQueryResolver {
        return ListOrderQueryResolver()
    }

    @Bean
    fun FindOrderByIdQueryResolverBean(): FindOrderByIdQueryResolver {
        return FindOrderByIdQueryResolver()
    }
}