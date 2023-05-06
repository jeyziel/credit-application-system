package me.dio.creditapplicationsystem.services.impl

import me.dio.creditapplicationsystem.entity.Customer
import me.dio.creditapplicationsystem.repository.CustomerRepository
import me.dio.creditapplicationsystem.services.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): ICustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)


    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw RuntimeException("Id $id not Found")
        }


    override fun delete(id: Long) =
        this.customerRepository.deleteById(id)
}