package io.spring.dataflow.sample.usagecostprocessor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UsageCostProcessorApplication

fun main(args: Array<String>) {
	runApplication<UsageCostProcessorApplication>(*args)
}
