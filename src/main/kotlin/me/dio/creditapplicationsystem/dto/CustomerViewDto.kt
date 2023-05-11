package me.dio.creditapplicationsystem.dto

import me.dio.creditapplicationsystem.entity.Customer
import java.math.BigDecimal

class CustomerViewDto(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    var income: BigDecimal,
    val email: String,
    val zipCode: String,
    val street: String
) {

    constructor(customer: Customer) : this(
        firstName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        zipCode = customer.address.zipCode,
        street = customer.address.street
    )

}