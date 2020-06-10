package com.alice.healthz.application

import org.junit.Assert.assertEquals
import org.junit.Test

class HealthServiceTest {

    @Test
    fun `execute service heathz`() {
        val service = HealthService()
        assertEquals("ok", service.execute())
    }
}
