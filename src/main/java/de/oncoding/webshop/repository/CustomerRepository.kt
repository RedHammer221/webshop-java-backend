package de.oncoding.webshop.repository

import de.oncoding.webshop.model.CustomerResponse
import java.util.*

class CustomerRepository {

    val customers = listOf(
        CustomerResponse(
            id = "1",
            firstName = "Masho",
            lastName = "Pilasov",
            email = "pilasov@gmail.com",
        )
    )

    fun findById(id: String): CustomerResponse? {
        return customers.find { it.id == id }
    }
}