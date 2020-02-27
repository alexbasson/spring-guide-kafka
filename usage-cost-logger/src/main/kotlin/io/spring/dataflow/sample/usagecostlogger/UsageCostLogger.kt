package io.spring.dataflow.sample.usagecostlogger

import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink

@EnableBinding(Sink::class)
class UsageCostLogger {

    private val logger = LoggerFactory.getLogger(UsageCostLoggerApplication::class.java)

    @StreamListener(Sink.INPUT)
    fun process(usageCostDetail: UsageCostDetail) {
        logger.info(usageCostDetail.toString())
    }
}
