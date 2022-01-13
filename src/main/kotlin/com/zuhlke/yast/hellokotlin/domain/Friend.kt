package com.zuhlke.yast.hellokotlin.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Friend(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,
    val name: String = "",
    val address: String? = "",
    val phoneNumber: String? = ""
) {
    constructor(name: String, address: String?, phoneNumber: String?) : this(id = 0, name, address, phoneNumber)
}