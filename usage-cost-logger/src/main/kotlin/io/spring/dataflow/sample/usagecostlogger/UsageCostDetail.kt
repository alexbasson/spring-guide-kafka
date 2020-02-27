package io.spring.dataflow.sample.usagecostlogger

import com.fasterxml.jackson.annotation.JsonProperty

data class UsageCostDetail(
    @JsonProperty("userId") val userId: String,
    @JsonProperty("callCost") val callCost: Double,
    @JsonProperty("dataCost") var dataCost: Double
)
