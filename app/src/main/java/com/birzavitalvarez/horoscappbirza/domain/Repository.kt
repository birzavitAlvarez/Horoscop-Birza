package com.birzavitalvarez.horoscappbirza.domain

import com.birzavitalvarez.horoscappbirza.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign:String): PredictionModel?
}