package com.apw.apw_project.controller

import com.apw.apw_project.model.EnviromentSensor
import com.apw.apw_project.repository.EnviromentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/enviroment"])
class EnviromentController {

    @Autowired
    private lateinit var enviromentRepository: EnviromentRepository

    @GetMapping("/add")
    fun addData(@RequestParam temperature: Float, @RequestParam humidity: Float): EnviromentSensor{
        val data = EnviromentSensor(temperature = temperature, humidity = humidity)
        return enviromentRepository.save(data)
    }

    @GetMapping
    fun getData() = enviromentRepository.findAll()
}