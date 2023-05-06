package me.dio.creditapplicationsystem.services

import me.dio.creditapplicationsystem.entity.Customer
import org.apache.el.stream.Optional

interface ICustomerService {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer

    fun delete(id: Long) : Unit

}