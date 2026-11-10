package com.example.educationandroidproject.data.api

import com.example.educationandroidproject.data.dto.AppDto
import kotlinx.coroutines.delay
import retrofit2.http.GET
import retrofit2.http.Path

interface CatalogApi {
    @GET("catalog")
    suspend fun getCatalog(): List<AppDto>

    @GET("catalog/{id}")
    suspend fun getAppById(@Path("id") id: String): AppDto

    suspend fun getRating(id: String): Float {
        delay(1500)
        return (30 .. 50).random() / 10f
    }
}