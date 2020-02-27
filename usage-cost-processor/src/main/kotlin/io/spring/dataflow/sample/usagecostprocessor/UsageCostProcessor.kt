package io.spring.dataflow.sample.usagecostprocessor

import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Processor
import org.springframework.messaging.handler.annotation.SendTo

@EnableBinding(Processor::class)
class UsageCostProcessor {

    private val ratePerSecond = 0.1
    private val ratePerMB = 0.05

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    fun processUsageCost(usageDetail: UsageDetail): UsageCostDetail {
        return UsageCostDetail(
            userId = usageDetail.userId,
            callCost = usageDetail.duration * ratePerSecond,
            dataCost = usageDetail.data * ratePerMB
        )
    }
}
