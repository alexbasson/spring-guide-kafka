package io.spring.dataflow.sample.usagecostlogger

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.spy
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.messaging.support.MessageBuilder
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
class UsageCostLoggerApplicationTests {

    @Autowired
    private lateinit var sink: Sink

    @Autowired
    private lateinit var usageCostLogger: UsageCostLogger

    @Test
    fun contextLoads() {
    }

    @Test
    fun `usage cost logger logs usage cost`() {
        val captor = ArgumentCaptor.forClass(UsageCostDetail::class.java)
        sink.input().send(MessageBuilder.withPayload("{\"userId\": \"user3\",\"callCost\":10.1,\"dataCost\":50.2}").build())
        verify(usageCostLogger).process(captor.capture())
    }

    @EnableAutoConfiguration
    @EnableBinding(Sink::class)
    internal class TestConfig {
        // Override `UsageCostLogger` bean for spying.
        @Bean
        @Primary
        fun usageCostLogger(): UsageCostLogger {
            return spy(UsageCostLogger())
        }
    }

}