package com.example.educationandroidproject.data.repository

import com.example.educationandroidproject.data.api.CatalogApi
import com.example.educationandroidproject.data.dto.AppDto
import com.example.educationandroidproject.data.mapper.AppMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class AppRepositoryImplTest {
    @Mock
    private lateinit var api: CatalogApi
    private lateinit var mapper: AppMapper
    private lateinit var repository: AppRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        mapper = AppMapper()
        repository = AppRepositoryImpl(api, mapper)
    }

    @Test
    fun `getApps should return mapped list from api`() = runTest {
        val dtos = listOf(AppDto("1", "App", "Desc", "Cat", "url"))
        whenever(api.getCatalog()).thenReturn(dtos)

        val result = repository.getApps()

        assertEquals(1, result.size)
        assertEquals("App", result[0].nameApp)
        verify(api).getCatalog()
    }

    @Test
    fun `getAppById should return mapped app from api`() = runTest {
        val dto = AppDto("1", "App", "Desc", "Cat", "url")
        whenever(api.getAppById("1")).thenReturn(dto)

        val result = repository.getAppById("1")

        assertEquals("App", result.nameApp)
        verify(api).getAppById("1")
    }

    @Test
    fun `getApps should return empty list if api returns empty list`() = runTest {
        whenever(api.getCatalog()).thenReturn(emptyList())

        val result = repository.getApps()

        assertEquals(0, result.size)
    }

    @Test
    fun `loadRatingsSequentially should return map of ratings`() = runTest {
        val ids = listOf("1", "2")
        whenever(api.getRating("1")).thenReturn(4.5f)
        whenever(api.getRating("2")).thenReturn(3.0f)

        val result = repository.loadRatingsSequentially(ids)

        assertEquals(4.5f, result["1"])
        assertEquals(3.0f, result["2"])
        verify(api).getRating("1")
        verify(api).getRating("2")
    }

    @Test
    fun `loadRatingsInParallel should return map of ratings`() = runTest {
        val ids = listOf("1", "2")
        whenever(api.getRating("1")).thenReturn(5.0f)
        whenever(api.getRating("2")).thenReturn(2.0f)

        val result = repository.loadRatingsInParallel(ids)

        assertEquals(2, result.size)
        assertEquals(5.0f, result["1"])
        verify(api).getRating("1")
    }
}