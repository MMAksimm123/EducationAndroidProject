package com.example.educationandroidproject.data.api

import com.example.educationandroidproject.data.dto.AppDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CatalogApi {
    @GET("catalog")
    suspend fun getCatalog(): List<AppDto>

    @GET("catalog/{id}")
    suspend fun getAppById(@Path("id") id: String): AppDto
}