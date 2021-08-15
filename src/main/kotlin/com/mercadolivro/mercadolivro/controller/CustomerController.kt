package com.mercadolivro.mercadolivro.controller

import com.mercadolivro.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.mercadolivro.model.CustomerModel
import com.mercadolivro.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("customer")
class CustomerController(
    val customerService: CustomerService
) {
    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customerService.getCustomer(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        customerService.create(customer)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody customer: PostCustomerRequest) {
        customerService.update(id, customer)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        customerService.delete(id)
    }
}
