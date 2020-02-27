package io.spring.dataflow.sample.usagedetailsender

import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.messaging.Source
import org.springframework.cloud.stream.test.binder.MessageCollector
import org.springframework.test.context.junit4.SpringRunner
import java.util.concurrent.TimeUnit

@RunWith(SpringRunner::class)
@SpringBootTest
class UsageDetailSenderApplicationTests {

    @Autowired
    private lateinit var messageCollector: MessageCollector

    @Autowired
    private lateinit var source: Source

    @Test
	fun contextLoads() {
	}

    @Test
    fun `usage detail sender sends usage details`() {
       val message = messageCollector.forChannel(source.output()).poll(1, TimeUnit.SECONDS)

        val usageDetailJSON = message.payload.toString()

        assertTrue(usageDetailJSON.contains("userId"))
        assertTrue(usageDetailJSON.contains("data"))
        assertTrue(usageDetailJSON.contains("duration"))
    }

}
