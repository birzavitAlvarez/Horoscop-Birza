package com.birzavitalvarez.horoscappbirza.data.network

import com.birzavitalvarez.horoscappbirza.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign:String):PredictionResponse

}