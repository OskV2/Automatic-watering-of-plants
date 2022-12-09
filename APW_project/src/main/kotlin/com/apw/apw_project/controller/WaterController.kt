package com.apw.apw_project.controller

import com.apw.apw_project.model.WaterSensor
import com.apw.apw_project.repository.WaterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/water"])
class WaterController {

    @Autowired
    private lateinit var waterRepository: WaterRepository

    @GetMapping("/add")
    fun addData(@RequestParam distance: Float): WaterSensor {
        val timestamp = System.currentTimeMillis()
        val data = WaterSensor(distance = distance, timestamp = timestamp)
        return waterRepository.save(data)
    }

    @GetMapping
    fun getData(): List<WaterSensor> = waterRepository.findAll()
}