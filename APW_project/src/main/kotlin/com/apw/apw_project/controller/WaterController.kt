package com.apw.apw_project.controller

import com.apw.apw_project.model.WaterSensor
import com.apw.apw_project.repository.WaterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping(value = ["/water"])
class WaterController {

    @Autowired
    private lateinit var repository: WaterRepository

    @GetMapping("/add")
    fun addData(@RequestParam distance: Float): WaterSensor {
        println("Nowy rekord pojemności wody: $distance")
        val timestamp = System.currentTimeMillis() / 1000
        val data = WaterSensor(distance = distance, timestamp = timestamp)
        return repository.save(data)
    }

    @GetMapping
    fun getData(): List<WaterSensor> = repository.findAll()
}