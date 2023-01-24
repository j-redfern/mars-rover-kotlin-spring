package com.kotlin.marsroverbackend.service

import com.kotlin.marsroverbackend.dto.Position
import org.springframework.stereotype.Service

@Service
class MarsRoverService {
    fun calculateMarsRoverPosition(): Position {
        return Position("6","3")
    }
}
