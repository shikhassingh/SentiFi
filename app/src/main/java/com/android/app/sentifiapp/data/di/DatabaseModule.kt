package com.android.app.sentifiapp.data.di

import android.content.Context
import androidx.room.Room
import com.android.app.sentifiapp.data.local.AppDatabase
import com.android.app.sentifiapp.data.local.dao.TransactionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDataBase (@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "expense_tracker_db"
            ).fallbackToDestructiveMigration(false)
            .build()
    }

    @Provides
    fun provideTransactionDao(appDatabase: AppDatabase): TransactionDao{
        return appDatabase.transactionDao()
    }
}