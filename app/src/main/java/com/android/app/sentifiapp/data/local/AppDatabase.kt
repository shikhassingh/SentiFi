package com.android.app.sentifiapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.app.sentifiapp.data.local.converter.Converters
import com.android.app.sentifiapp.data.local.dao.TransactionDao
import com.android.app.sentifiapp.data.local.entity.CategoryEntity
import com.android.app.sentifiapp.data.local.entity.MoodTagEntity
import com.android.app.sentifiapp.data.local.entity.SplitBillEntity
import com.android.app.sentifiapp.data.local.entity.SubscriptionEntity
import com.android.app.sentifiapp.data.local.entity.TransactionEntity

@Database(
    entities = [
        TransactionEntity::class,
        CategoryEntity::class,
        MoodTagEntity::class,
        SubscriptionEntity::class,
        SplitBillEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
}