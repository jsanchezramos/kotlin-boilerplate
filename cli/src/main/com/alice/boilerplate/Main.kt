package com.alice.boilerplate

import com.alice.boilerplate.injection.moduleApi
import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.koin.core.context.startKoin

fun main(args: Array<String>) {
    startKoin {
        modules(moduleApi)
    }

    embeddedServer(Netty, commandLineEnvironment(args)).start()
}
