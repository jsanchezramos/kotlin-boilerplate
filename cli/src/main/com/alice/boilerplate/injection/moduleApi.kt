package com.alice.boilerplate.injection

import com.alice.alice.healthz.application.HealthService
import com.alice.boilerplate.heatlhz.ApiHealth
import org.koin.dsl.module

val moduleApi = module {
    single { HealthService() }
    single { ApiHealth(get()) }
}
