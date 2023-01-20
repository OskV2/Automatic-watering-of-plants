package com.apw.apw_project.repository

import com.apw.apw_project.model.TemperatureSensor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TemperatureRepository: JpaRepository<TemperatureSensor, Long> {}