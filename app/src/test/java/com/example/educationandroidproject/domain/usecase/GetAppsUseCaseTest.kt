package com.example.educationandroidproject.domain.usecase

import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.domain.repository.AppRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class GetAppsUseCaseTest {
    @Mock
    private lateinit var repository: AppRepository
    private lateinit var useCase: GetAppsUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetAppsUseCase(repository)
    }

    @Test
    fun `invoke should return list of apps from repository`() = runTest {
        val apps = listOf(
            AppItem("1", "url", "App 1", "Desc", "Cat"),
            AppItem("2", "url", "App 2", "Desc", "Cat")
        )
        whenever(repository.getApps()).thenReturn(apps)

        val result = useCase()

        assertEquals(2, result.size)
        verify(repository).getApps()
    }

    @Test
    fun `invoke should return empty list when repository returns empty`() = runTest {
        whenever(repository.getApps()).thenReturn(emptyList())

        val result = useCase()

        assertTrue(result.isEmpty())
    }

    @Test
    fun `invoke should propagate exception from repository`() = runTest {
        val exception = RuntimeException("Network error")
        whenever(repository.getApps()).thenThrow(exception)

        try {
            useCase()
        } catch (e: Exception) {
            assertEquals("Network error", e.message)
        }
    }

    @Test
    fun `invoke should call repository exactly once`() = runTest {
        whenever(repository.getApps()).thenReturn(emptyList())

        useCase()

        verify(repository, org.mockito.kotlin.times(1)).getApps()
    }

    @Test
    fun `invoke should return items with correct names`() = runTest {
        val apps = listOf(AppItem("1", "url", "SpecificName", "Desc", "Cat"))
        whenever(repository.getApps()).thenReturn(apps)

        val result = useCase()

        assertEquals("SpecificName", result[0].nameApp)
    }
}