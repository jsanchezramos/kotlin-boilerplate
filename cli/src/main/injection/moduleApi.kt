package injection

import healthz.application.HealthService
import heatlhz.ApiHealth
import org.koin.dsl.module

val moduleApi = module {
    single { HealthService() }
    single { ApiHealth(get()) }
}
