package com.kotlin.marsroverbackend.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.kotlin.marsroverbackend.fixtures.FormDto
import com.kotlin.marsroverbackend.fixtures.PositionDto
import com.kotlin.marsroverbackend.service.MarsRoverService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest

import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@WebMvcTest(MarsRoverController::class)
@ActiveProfiles("test")
internal class MarsRoverControllerTest {

    @Suppress("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockkBean
    lateinit var marsRoverService: MarsRoverService

    private val objectMapper = jacksonObjectMapper()

   @Test
   @DisplayName("/POST returns final position when 200")
   fun post() {
       val form = FormDto.createForm("10","10","1","3", "N","FFFFF")
       val finalPosition = PositionDto.createPosition("6","3")

       every { marsRoverService.calculateMarsRoverPosition() } returns finalPosition

       mockMvc.post("/mars-rover/finalPosition") {
           contentType = MediaType.APPLICATION_JSON
           content = objectMapper.writeValueAsString(form)
           accept = MediaType.APPLICATION_JSON
       }.andExpect {
           status { isOk() }
           content { contentType(MediaType.APPLICATION_JSON) }
           content { json(objectMapper.writeValueAsString(finalPosition)) }
       }
   }
}
