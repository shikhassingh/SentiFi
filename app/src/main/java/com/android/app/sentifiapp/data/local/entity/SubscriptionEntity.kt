package com.android.app.sentifiapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subscriptions")
data class SubscriptionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val billingCycleDays: Int,
    val nextBillingDate: Long,
    val amount: Double,
    val isAutoRenewalActive: Boolean = true

)
