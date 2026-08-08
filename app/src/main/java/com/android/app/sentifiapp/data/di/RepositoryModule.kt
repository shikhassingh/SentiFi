package com.android.app.sentifiapp.data.di

import com.android.app.sentifiapp.data.local.AppDatabase
import com.android.app.sentifiapp.data.local.dao.TransactionDao
import com.android.app.sentifiapp.data.repository.TransactionRepositoryImpl
import com.android.app.sentifiapp.domain.repository.TransactionRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindsTransactionRepository(transactionRepositoryImpl: TransactionRepositoryImpl): TransactionRepository
}