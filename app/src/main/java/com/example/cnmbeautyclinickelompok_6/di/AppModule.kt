package com.example.cnmbeautyclinickelompok_6.di

import android.content.Context
import com.example.cnmbeautyclinickelompok_6.data.DBHelper
import com.example.cnmbeautyclinickelompok_6.data.SessionManager
import com.example.cnmbeautyclinickelompok_6.data.TreatmentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDBHelper(
        @ApplicationContext context: Context
    ): DBHelper {
        return DBHelper(context)
    }

    @Provides
    @Singleton
    fun provideSessionManager(
        @ApplicationContext context: Context
    ): SessionManager {
        return SessionManager(context)
    }

    @Provides
    @Singleton
    fun provideTreatmentRepository(): TreatmentRepository {
        return TreatmentRepository()
    }
}