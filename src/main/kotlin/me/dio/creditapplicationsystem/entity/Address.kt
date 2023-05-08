package me.dio.creditapplicationsystem.entity

import jakarta.persistence.Column

data class Address(
    @Column(nullable = false)
    var zipCode: String = "",
    @Column(nullable = false)
    var street: String = "",
)
