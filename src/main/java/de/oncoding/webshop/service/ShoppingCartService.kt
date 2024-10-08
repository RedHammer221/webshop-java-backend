package de.oncoding.webshop.service

import de.oncoding.webshop.exceptions.IdNotFoundException
import de.oncoding.webshop.model.OrderPositionResponse
import de.oncoding.webshop.model.OrderResponse
import de.oncoding.webshop.model.ProductResponse
import de.oncoding.webshop.model.ShoppingCartResponse
import de.oncoding.webshop.repository.OrderPositionRepository
import org.springframework.stereotype.Service
import de.oncoding.webshop.repository.OrderRepository
import de.oncoding.webshop.repository.ProductRepository
import org.springframework.web.bind.annotation.PathVariable
import java.util.*

@Service
class ShoppingCartService(
    val orderRepository: OrderRepository,
    val orderPositionRepository: OrderPositionRepository,
    val productRepository: ProductRepository
) {

    fun getShoppingCartForCustomer(customerId: String): ShoppingCartResponse {

        val orders: List<OrderResponse> = orderRepository.findAllByCustomerIdWhereOrderStatusIsNew(customerId)
        val orderIds = orders.map { it.id }

        val orderPositions = orderPositionRepository.findAllByOrderIds(orderIds)

        val deliveryCost = 800L // TODO: feature to select delivery method
        val totalAmount = calculateSumForCart(orderPositions, deliveryCost)

        return ShoppingCartResponse(
            customerId = customerId,
            orderPositions = orderPositions,
            deliveryOption = "STANDARD",
            deliveryCostInCent = deliveryCost,
            totalPriceInCent = totalAmount
            )
    }

    fun calculateSumForCart(
        orderPositions: List<OrderPositionResponse>,
        deliveryCost: Long
    ): Long {
        val positionAmounts: List<Long> = orderPositions.map {
            val product: ProductResponse = productRepository
                .findById(it.productId)
                .orElseThrow { throw IdNotFoundException("Product with id ${it.productId} not found") }
            if (it.quantity <= 0)
                throw IllegalArgumentException("OrderPosition with quantity of ${it.quantity} is not allowed.")
            it.quantity * product.priceInCent
        }
        val positionSum = positionAmounts.sumBy { it.toInt() }
        return positionSum + deliveryCost
    }

}
