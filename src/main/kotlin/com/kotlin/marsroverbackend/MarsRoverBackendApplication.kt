package com.kotlin.marsroverbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MarsRoverBackendApplication

fun main(args: Array<String>) {
	runApplication<MarsRoverBackendApplication>(*args)
}
