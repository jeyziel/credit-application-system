package me.dio.creditapplicationsystem.services.impl

import me.dio.creditapplicationsystem.entity.Customer
import me.dio.creditapplicationsystem.exceptions.BusinessException
import me.dio.creditapplicationsystem.repository.CustomerRepository
import me.dio.creditapplicationsystem.services.ICustomerService
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): ICustomerService {
    @PostMapping
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)


    @GetMapping
    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw BusinessException("Id $id not Found")
        }


   @DeleteMapping
    override fun delete(id: Long) =
        this.customerRepository.deleteById(id)
}