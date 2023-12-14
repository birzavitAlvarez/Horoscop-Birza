package com.birzavitalvarez.horoscappbirza.data.network

import com.birzavitalvarez.horoscappbirza.BuildConfig
import com.birzavitalvarez.horoscappbirza.BuildConfig.BASE_URL
import com.birzavitalvarez.horoscappbirza.data.RepositoryImpl
import com.birzavitalvarez.horoscappbirza.data.core.interceptors.AuthInterceptor
import com.birzavitalvarez.horoscappbirza.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    //val base = "https://newastro-debug.vercel.app/"

    @Provides
    @Singleton   // patron de disenio para unica instancia de una clase
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit
                .Builder()
                .baseUrl("https://newastro-debug.vercel.app/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor):OkHttpClient{
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()
    }


    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit): HoroscopeApiService {
        return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: HoroscopeApiService): Repository {
        return RepositoryImpl(apiService)
    }

}