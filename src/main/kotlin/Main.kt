import io.opentelemetry.api.trace.Span
import io.opentelemetry.instrumentation.annotations.WithSpan
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


fun main() {
    runBlocking {
        first()
    }
}

@WithSpan
suspend fun first() {
    println("first - span: ${Span.current()}")
    second()
}


suspend fun second() {
    println("second 1 - span: ${Span.current()}")
    third()
    println("second 2 - span: ${Span.current()}")
    third()
}

@WithSpan
suspend fun third() {
    println("third - span: ${Span.current()}")
    delay(200)
}
