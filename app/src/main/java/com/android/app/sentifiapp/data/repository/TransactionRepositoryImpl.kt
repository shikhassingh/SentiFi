package com.android.app.sentifiapp.data.repository

import com.android.app.sentifiapp.data.local.dao.TransactionDao
import com.android.app.sentifiapp.data.local.entity.TransactionEntity
import com.android.app.sentifiapp.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val transactionDao: TransactionDao
): TransactionRepository {
    override suspend fun insertTransaction(transaction: TransactionEntity): Long {
        return transactionDao.insertTransaction(transaction)
    }

    override suspend fun deleteTransaction(transaction: TransactionEntity) {
        return transactionDao.deleteTransaction(transaction)
    }

    override fun getAllTransactions(): Flow<List<TransactionEntity>> {
        return  transactionDao.getAllTransactions()
    }

    override fun getTransactionBetweenDates(
        startDate: Long,
        endDate: Long
    ): Flow<List<TransactionEntity>> {
         return transactionDao.getTransactionBetweenDates(startDate, endDate)
    }

    override fun getTotalSpentInPeriod(
        startDate: Long,
        endDate: Long
    ): Double {
        return transactionDao.getTotalSpentInPeriod(startDate, endDate)
    }

}
