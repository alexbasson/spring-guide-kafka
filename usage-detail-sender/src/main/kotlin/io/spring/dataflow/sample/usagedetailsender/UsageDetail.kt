package io.spring.dataflow.sample.usagedetailsender

data class UsageDetail(
    val userId: String,
    val data: Int,
    var duration: Int
)
