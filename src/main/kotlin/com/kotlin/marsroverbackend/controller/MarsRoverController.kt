package com.kotlin.marsroverbackend.controller

import com.kotlin.marsroverbackend.dto.FinalPosition
import com.kotlin.marsroverbackend.dto.FormContents
import com.kotlin.marsroverbackend.dto.finalPosition
import com.kotlin.marsroverbackend.service.MarsRoverService
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
    fun calculateFinalPosition(@RequestBody formContents: FormContents): ResponseEntity<FinalPosition> {
        return ResponseEntity.ok(finalPosition(marsRoverService.calculateMarsRoverPosition()))
    }
}
