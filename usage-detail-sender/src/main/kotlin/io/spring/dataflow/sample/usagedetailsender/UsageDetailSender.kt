package io.spring.dataflow.sample.usagedetailsender

import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.messaging.Source
import org.springframework.messaging.support.MessageBuilder
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import java.util.*

@EnableScheduling
@EnableBinding(Source::class)
class UsageDetailSender(private val source: Source) {

    private val users = arrayOf("user1", "user2", "user3", "user4", "user5")

    @Scheduled(fixedDelay = 1000)
    fun sendEvents() {
        val usageDetail = UsageDetail(
            userId = users[Random().nextInt(users.size)],
            data = Random().nextInt(300),
            duration = Random().nextInt(700)
        )
        source.output().send(MessageBuilder.withPayload(usageDetail).build())
    }

}
