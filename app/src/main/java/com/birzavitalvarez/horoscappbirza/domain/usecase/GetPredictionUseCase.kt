package com.birzavitalvarez.horoscappbirza.domain.usecase

import com.birzavitalvarez.horoscappbirza.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)
}