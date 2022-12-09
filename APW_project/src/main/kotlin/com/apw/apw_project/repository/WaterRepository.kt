package com.apw.apw_project.repository

import com.apw.apw_project.model.WaterSensor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WaterRepository: JpaRepository<WaterSensor, Long> {}