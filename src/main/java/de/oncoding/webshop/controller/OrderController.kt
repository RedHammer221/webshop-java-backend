package de.oncoding.webshop.controller

import de.oncoding.webshop.exceptions.WebshopException
import de.oncoding.webshop.model.OrderCreateRequest
import de.oncoding.webshop.model.OrderPositionCreateRequest
import de.oncoding.webshop.model.OrderResponse
import de.oncoding.webshop.model.OrderUpdateRequest
import de.oncoding.webshop.repository.OrderRepository
import de.oncoding.webshop.repository.ProductRepository
import de.oncoding.webshop.service.OrderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class OrderController(
    val orderService: OrderService
) {

    @PostMapping("/orders")
    fun createOrder(
        @RequestBody request: OrderCreateRequest
    ): OrderResponse {
            return orderService.createOrder(request)
    }

    @PostMapping("/orders/{id}/positions")
    fun createOrderPosition(
        @PathVariable(name = "id") orderId: String,
        @RequestBody request: OrderPositionCreateRequest
    ) {
        orderService.createNewPositionForOrder(orderId, request)
    }

    @PutMapping("/orders/{id}")
    fun updateOrder(
        @PathVariable id: String,
        @RequestBody request: OrderUpdateRequest
    ){
        orderService.updateOrder(id, request)
    }
}