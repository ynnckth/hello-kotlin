package com.zuhlke.yast.hellokotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class HelloKotlinApplication

fun main(args: Array<String>) {
	runApplication<HelloKotlinApplication>(*args)
}
