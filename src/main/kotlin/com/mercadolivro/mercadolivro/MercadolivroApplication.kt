package com.mercadolivro.mercadolivro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class MercadolivroApplication

fun main(args: Array<String>) {
	runApplication<MercadolivroApplication>(*args)
}
