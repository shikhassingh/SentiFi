package com.android.app.sentifiapp.domain.repository

import androidx.room.Delete
import androidx.room.Query
import com.android.app.sentifiapp.data.local.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    suspend fun insertTransaction(transaction: TransactionEntity): Long

    suspend fun deleteTransaction(transaction: TransactionEntity)

    fun getAllTransactions(): Flow<List<TransactionEntity>>

    fun getTransactionBetweenDates(startDate: Long, endDate: Long): Flow<List<TransactionEntity>>

    fun getTotalSpentInPeriod(startDate: Long, endDate: Long): Double
}