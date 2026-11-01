package com.example.educationandroidproject.di

import com.example.educationandroidproject.data.repository.AppRepositoryImpl
import com.example.educationandroidproject.domain.repository.AppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAppRepository(
        impl: AppRepositoryImpl
    ) : AppRepository
}