package com.alice.boilerplate.heatlhz

import com.alice.boilerplate.healthz.application.HealthService
import java.util.Date

class ApiHealth(private val service: HealthService) {
    fun execute(): Response {
        return Response(status = service.execute(), time = Date().toString())
    }
}
