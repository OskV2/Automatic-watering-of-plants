package com.apw.apw_project.repository

import com.apw.apw_project.model.EnviromentSensor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EnviromentRepository: JpaRepository<EnviromentSensor, Long> {}