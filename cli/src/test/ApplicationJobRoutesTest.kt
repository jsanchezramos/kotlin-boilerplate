import com.alice.boilerplate.injection.moduleApi
import com.alice.boilerplate.router.main
import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import kotlin.test.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest

class ApplicationJobRoutesTest : AutoCloseKoinTest() {
    @Before
    fun before() {
        startKoin {
            modules(moduleApi)
        }
    }

    @Test
    fun testHelloRequest() = withTestApplication(Application::main) {
        with(handleRequest(HttpMethod.Get, "/health")) {
            assertEquals(HttpStatusCode.OK, response.status())
        }
    }
}
