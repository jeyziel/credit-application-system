package me.dio.creditapplicationsystem.entity

import jakarta.persistence.Column

data class Address(
    @Column(nullable = false)
    val zipCode: String = "",
    @Column(nullable = false)
    val street: String = "",
)
