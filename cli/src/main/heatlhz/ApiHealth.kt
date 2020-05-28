package heatlhz

import healthz.application.HealthService
import java.util.*

class ApiHealth(private val service: HealthService) {
    fun execute() : Response{
        return Response(status = service.execute(), time = Date().toString())
    }
}