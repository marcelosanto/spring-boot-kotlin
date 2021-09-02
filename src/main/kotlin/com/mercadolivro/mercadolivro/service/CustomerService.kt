package com.mercadolivro.mercadolivro.service

import com.mercadolivro.mercadolivro.model.CustomerModel
import com.mercadolivro.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {
    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun getCustomer(id: Int): CustomerModel {
        return customerRepository.findById(id).get()
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun update(customer: CustomerModel) {
        customers.filter { it.id == customer.id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: Int) {
        customers.removeIf { it.id == id }
    }
}
