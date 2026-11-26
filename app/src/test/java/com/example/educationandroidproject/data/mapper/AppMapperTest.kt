package com.example.educationandroidproject.data.mapper

import com.example.educationandroidproject.data.dto.AppDto
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AppMapperTest {
    private lateinit var mapper: AppMapper

    @Before
    fun setUp() {
        mapper = AppMapper()
    }

    @Test
    fun `mapToDomain should map all fields correctly`() {
        val dto = AppDto("1", "Test Name", "Test Desc", "Test Category", "http://test.com/icon.png")
        val domain = mapper.mapToDomain(dto)

        assertEquals(dto.id, domain.id)
        assertEquals(dto.name, domain.nameApp)
        assertEquals(dto.description, domain.description)
        assertEquals(dto.category, domain.category)
        assertEquals(dto.iconUrl, domain.iconUrl)
    }

    @Test
    fun `mapToDomain should handle empty strings`() {
        val dto = AppDto("", "", "", "", "")
        val domain = mapper.mapToDomain(dto)
        assertEquals("", domain.nameApp)
    }

    @Test
    fun `mapToDomainList should map list of dtos correctly`() {
        val dtos = listOf(
            AppDto("1", "App 1", "Desc 1", "Cat 1", "url1"),
            AppDto("2", "App 2", "Desc 2", "Cat 2", "url2")
        )
        val domains = mapper.mapToDomainList(dtos)

        assertEquals(2, domains.size)
        assertEquals("App 1", domains[0].nameApp)
        assertEquals("App 2", domains[1].nameApp)
    }

    @Test
    fun `mapToDomainList should return empty list when input is empty`() {
        val domains = mapper.mapToDomainList(emptyList())
        assertEquals(0, domains.size)
    }

    @Test
    fun `mapToDomain should preserve id`() {
        val dto = AppDto("uuid-1234", "App", "Desc", "Cat", "url")
        val domain = mapper.mapToDomain(dto)
        assertEquals("uuid-1234", domain.id)
    }
}