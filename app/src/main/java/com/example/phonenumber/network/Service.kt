package com.example.phonenumber.network

import com.example.phonenumber.util.Constant
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Service {
    private var retrofit: Retrofit? = null

    fun getClientHeaderTwillo(TWILLIO_BASE_URL
                              :String): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        val httpClient = OkHttpClient.Builder()
        var credentials: String = Credentials.basic(Constant.TWILLIO_USERNAME,Constant.TWILLIO_PASSWORD)
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("Authorization", credentials)
                .method(original.method, original.body)
                .build()
            chain.proceed(request)
        }

        httpClient.interceptors().add(httpLoggingInterceptor)
        httpClient.readTimeout(120, TimeUnit.SECONDS)
        httpClient.connectTimeout(120, TimeUnit.SECONDS)

        val client = httpClient.build()
        retrofit = Retrofit.Builder()
            .baseUrl(TWILLIO_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

        return retrofit!!
    }
}