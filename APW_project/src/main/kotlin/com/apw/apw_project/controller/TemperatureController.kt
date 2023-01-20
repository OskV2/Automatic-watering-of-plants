package com.apw.apw_project.controller


import com.apw.apw_project.model.TemperatureSensor
import com.apw.apw_project.repository.TemperatureRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping(value = ["/temperature"])
class TemperatureController {

    @Autowired
    private lateinit var repository: TemperatureRepository

    @GetMapping("/add")
    fun addData(@RequestParam temperature: Float): TemperatureSensor {
        println("Nowa wartość temperatury: $temperature")
        val timestamp = System.currentTimeMillis() / 1000
        val data = TemperatureSensor(temperature = temperature, timestamp = timestamp)
        return repository.save(data)
    }

    @GetMapping
    fun getData(): List<TemperatureSensor> = repository.findAll()
}