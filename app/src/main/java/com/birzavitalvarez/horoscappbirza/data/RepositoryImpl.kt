package com.birzavitalvarez.horoscappbirza.data

import android.util.Log
import com.birzavitalvarez.horoscappbirza.data.network.HoroscopeApiService
import com.birzavitalvarez.horoscappbirza.domain.Repository
import com.birzavitalvarez.horoscappbirza.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {

    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("birza", "Ha ocurrido un error ${it.message}") }
        return null
    }
}

