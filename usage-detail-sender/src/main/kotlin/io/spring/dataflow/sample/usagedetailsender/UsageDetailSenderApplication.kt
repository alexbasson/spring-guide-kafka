package io.spring.dataflow.sample.usagedetailsender

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UsageDetailSenderApplication

fun main(args: Array<String>) {
	runApplication<UsageDetailSenderApplication>(*args)
}
