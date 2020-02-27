package io.spring.dataflow.sample.usagecostprocessor

data class UsageCostDetail(
    val userId: String,
    val callCost: Double,
    val dataCost: Double
)
