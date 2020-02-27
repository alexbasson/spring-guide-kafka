package io.spring.dataflow.sample.usagecostlogger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UsageCostLoggerApplication

fun main(args: Array<String>) {
    runApplication<UsageCostLoggerApplication>(*args)
}
