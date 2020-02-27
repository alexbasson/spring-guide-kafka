package io.spring.dataflow.sample.usagecostprocessor

import com.fasterxml.jackson.annotation.JsonProperty

data class UsageDetail(
    @JsonProperty("userId") val userId: String,
    @JsonProperty("data") val data: Int,
    @JsonProperty("duration") val duration: Int
)
