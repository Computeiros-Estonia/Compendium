package com.estoniatech.compendium.dto

data class QueryResultDTO(
    val start: Double,
    val numFound: Double,
    val docs: List<DocDTO>
)