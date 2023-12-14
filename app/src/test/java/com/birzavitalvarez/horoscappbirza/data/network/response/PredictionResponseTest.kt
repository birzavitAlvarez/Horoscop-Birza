package com.birzavitalvarez.horoscappbirza.data.network.response

import com.birzavitalvarez.horoscappbirza.motherobject.HoroscopeMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test

class PredictionResponseTest {

    @Test
    fun `toDomain should return a correct PredictionModel`() {
        //Given
        val horoscopeResponse = anyResponse

        //When
        val predictionModel = horoscopeResponse.toDomain()

        //Then
        predictionModel.sign shouldBe horoscopeResponse.sign
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope
    }
}