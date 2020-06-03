package com.alice.boilerplate.router

import com.alice.boilerplate.heatlhz.ApiHealth
import com.fasterxml.jackson.core.util.DefaultIndenter
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.Compression
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.jackson.jackson
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import org.koin.ktor.ext.inject

fun Application.main() {
    // Install Ktor features
    install(DefaultHeaders)
    install(CallLogging)
    install(Compression)
    install(ContentNegotiation) {
        jackson {
            configure(SerializationFeature.INDENT_OUTPUT, true)
            setDefaultPrettyPrinter(DefaultPrettyPrinter().apply {
                indentArraysWith(DefaultPrettyPrinter.FixedSpaceIndenter.instance)
                indentObjectsWith(DefaultIndenter("  ", "\n"))
            })
            registerModule(JavaTimeModule()) // support java.time.* types
        }
    }
    // Lazy inject HealthService
    val apiHealth: ApiHealth by inject()

    // Routing section
    routing {
        get("/health") {
            call.respond(apiHealth.execute())
        }
    }
}
