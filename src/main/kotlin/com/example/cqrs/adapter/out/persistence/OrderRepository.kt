package com.example.cqrs.adapter.out.persistence

import com.example.cqrs.domain.order.core.Order
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
interface OrderRepository: CrudRepository<Order, Long> {
}