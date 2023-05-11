package me.dio.creditapplicationsystem.controller

import me.dio.creditapplicationsystem.dto.CreditViewList
import me.dio.creditapplicationsystem.dto.CustomerDto
import me.dio.creditapplicationsystem.dto.CustomerUpdateDto
import me.dio.creditapplicationsystem.dto.CustomerViewDto
import me.dio.creditapplicationsystem.entity.Customer
import me.dio.creditapplicationsystem.services.impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/customers")
class CustomerResource(
    private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): ResponseEntity<String> {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return ResponseEntity.status(HttpStatus.OK)
            .body("Customer ${savedCustomer.email} saved!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : ResponseEntity<CustomerViewDto>{
        val customer: Customer = this.customerService.findById(id)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(CustomerViewDto(customer))
    }


    /*fun findAll(): ResponseEntity<List<CustomerViewDto>>{
        val customers: Customer = this.customerService.findAll()
    }*/

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)


    @PatchMapping
    fun updateCustomer(
        @RequestParam(value= "customerId") id: Long,
        @RequestBody customerUpdateDto: CustomerUpdateDto
    ): CustomerViewDto {

        val customer = this.customerService.findById(id)
        val customerUpdate = this.customerService.save(
            customerUpdateDto.toEntity(customer)
        )

        return CustomerViewDto(customerUpdate)

    }





}