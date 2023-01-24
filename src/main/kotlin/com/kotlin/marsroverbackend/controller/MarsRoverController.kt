package com.kotlin.marsroverbackend.controller

import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.kotlin.marsroverbackend.dto.FormContents
import com.kotlin.marsroverbackend.dto.Position
import com.kotlin.marsroverbackend.service.MarsRoverService
import org.jetbrains.kotlin.com.google.gson.JsonObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class MarsRoverController {

    @Autowired
    lateinit var marsRoverService: MarsRoverService

    @PostMapping("/mars-rover/finalPosition")
    @ResponseStatus(HttpStatus.OK)
    //todo add exception handler
    fun calculateFinalPosition(@RequestBody formContents: FormContents) : ResponseEntity<Position> {
        return ResponseEntity.ok(marsRoverService.calculateMarsRoverPosition())
    }


}
