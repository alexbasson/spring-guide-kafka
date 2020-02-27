package io.spring.dataflow.sample.usagecostprocessor

import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.messaging.Processor
import org.springframework.cloud.stream.test.binder.MessageCollector
import org.springframework.messaging.support.MessageBuilder
import org.springframework.test.context.junit4.SpringRunner
import java.util.concurrent.TimeUnit

@RunWith(SpringRunner::class)
@SpringBootTest
class UsageCostProcessorApplicationTests {

    @Autowired
    private lateinit var processor: Processor

    @Autowired
    private lateinit var messageCollector: MessageCollector

	@Test
	fun contextLoads() {
	}

    @Test
    fun `usage cost processor processes usage cost`() {
        processor.input().send(MessageBuilder.withPayload("{\"userId\": \"user3\", \"data\": 101, \"duration\": 502}").build())
        val message = messageCollector.forChannel(processor.output()).poll(1, TimeUnit.SECONDS)
        assertTrue(message.payload.toString().equals("{\"userId\":\"user3\",\"callCost\":50.2,\"dataCost\":5.050000000000001}"))
    }
}
