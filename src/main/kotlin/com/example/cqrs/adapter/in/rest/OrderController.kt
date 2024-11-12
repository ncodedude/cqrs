package com.example.cqrs.adapter.`in`.rest

import com.example.cqrs.adapter.`in`.rest.request.order.CreateOrderRequest
import com.example.cqrs.adapter.`in`.rest.request.order.UpdateOrderRequest
import com.example.cqrs.adapter.`in`.rest.response.order.CreateOrderResponse
import com.example.cqrs.adapter.`in`.rest.response.order.UpdateOrderResponse
import com.example.cqrs.common.application.ApplicationDispatcherContextInterface
import com.example.cqrs.domain.order.application.query.find.FindOrderByIdQuery
import com.example.cqrs.domain.order.application.query.list.ListOrderQuery
import org.springframework.web.bind.annotation.*


@RestController()
@RequestMapping("api/v1/orders")
class OrderController(private val applicationDispatcher: ApplicationDispatcherContextInterface)
{
    @PostMapping()
    fun creatNewOrder(@RequestBody orderRequest: CreateOrderRequest): CreateOrderResponse {
        val  command =  orderRequest.toCommand()
        val response = this.applicationDispatcher.execute(command) as Long;
        return CreateOrderResponse(response)
    }

    @PutMapping("/{id}")
    fun updateOrder(@PathVariable id: Long, @RequestBody orderRequest: UpdateOrderRequest): UpdateOrderResponse {
        val  command =  orderRequest.toCommand(id)
        val response = this.applicationDispatcher.execute(command) as Long;
        return UpdateOrderResponse(response)
    }

    @GetMapping()
    fun listOrders(): Any {
        val result = this.applicationDispatcher.execute(ListOrderQuery())
        return result
    }

    @GetMapping("/{id}")
    fun findOrderById(@PathVariable id: Long): Any {
        val result = this.applicationDispatcher.execute(FindOrderByIdQuery(id))
        return result
    }
}