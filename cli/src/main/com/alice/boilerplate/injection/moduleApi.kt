package com.alice.boilerplate.injection

import com.alice.boilerplate.heatlhz.ApiHealth
import com.alice.healthz.application.HealthService
import org.koin.dsl.module

val moduleApi = module {
    single { HealthService() }
    single { ApiHealth(get()) }
}
