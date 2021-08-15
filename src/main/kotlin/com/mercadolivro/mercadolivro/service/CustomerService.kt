package com.mercadolivro.mercadolivro.service

import com.mercadolivro.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
class CustomerService {
    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun getCustomer(id: String): CustomerModel {
        return customers.filter { it.id == id }.first()
    }

    fun create(customer: PostCustomerRequest) {

        var id = if (customers.isEmpty()) {
            1
        } else { customers.last().id.toInt() + 1 }.toString()

        customers.add(CustomerModel("1", customer.name, customer.email))
        println(customer)
    }

    fun update(id: String, customer: PostCustomerRequest) {
        customers.filter { it.id == id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }


    fun delete(id: String) {
        customers.removeIf { it.id == id }
    }
}
