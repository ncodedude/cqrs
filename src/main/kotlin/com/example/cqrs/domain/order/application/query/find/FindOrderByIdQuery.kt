package com.example.cqrs.domain.order.application.query.find

import com.example.cqrs.common.application.query.ApplicationQuery
import com.example.cqrs.domain.order.core.Order

class FindOrderByIdQuery(val id: Long): ApplicationQuery<Order> {
}