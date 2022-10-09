package com.example.sampleproject.di

import android.content.Context
import com.example.sampleproject.data.local.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun getAppDatabase(@ApplicationContext context: Context) = AppDataBase.getDatabase(context)
}