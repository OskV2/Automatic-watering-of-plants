package com.apw.apw_project.controller

import com.apw.apw_project.model.SoilMoisture
import com.apw.apw_project.repository.SoilMoistureRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping(value = ["/soilMoisture"])
class SoilMoistureController {
    @Autowired
    private lateinit var repository: SoilMoistureRepository

    @GetMapping("/add")
    fun addData(@RequestParam humidity: Float): SoilMoisture {
        println("Nowy rekord wilgotności gleby: $humidity")
        val timestamp = System.currentTimeMillis() / 1000
        val data = SoilMoisture(humidity = humidity, timestamp = timestamp)
        return repository.save(data)
    }

    @GetMapping
    fun getData(): List<SoilMoisture> = repository.findAll()
}