package de.bonimporter.app.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReceiptDto(
    val id: String,
    val store: String,
    val storeAddress: String?,
    val storeId: String?,
    val cashRegisterId: String?,
    val date: String,           // ISO-8601
    val bonNumber: String?,
    val totalGross: String,     // Decimal as string from API
    val totalNet: String?,
    val totalTax: String?,
    val paymentMethod: String?,
    val sourceFile: String?,
    val importSource: String,
    val createdAt: String,
    val items: List<LineItemDto> = emptyList(),
    val taxEntries: List<TaxEntryDto> = emptyList(),
)

@JsonClass(generateAdapter = true)
data class LineItemDto(
    val id: String,
    val receiptId: String,
    val name: String,
    val priceGross: String,
    val taxCategory: String,
    val isDiscount: Boolean,
    val isDeposit: Boolean,
    val quantity: String?,
    val quantityUnit: String?,
    val unitPrice: String?,
    val paybackEligible: Boolean,
)

@JsonClass(generateAdapter = true)
data class TaxEntryDto(
    val id: String,
    val receiptId: String,
    val category: String,
    val rate: String,
    val net: String,
    val tax: String,
    val gross: String,
)

@JsonClass(generateAdapter = true)
data class ReceiptsPageDto(
    val receipts: List<ReceiptDto>,
    val total: Int,
    val page: Int,
    val limit: Int,
    val totalPages: Int,
)

@JsonClass(generateAdapter = true)
data class StatsDto(
    val totalSpend: String,
    val receiptCount: Int,
    val avgPerReceipt: String,
    val topItems: List<TopItemDto>,
    val monthlyTotals: List<MonthlyTotalDto>,
    val storeBreakdown: List<StoreBreakdownDto>,
)

@JsonClass(generateAdapter = true)
data class TopItemDto(
    val name: String,
    val count: Int,
    val totalSpend: String,
)

@JsonClass(generateAdapter = true)
data class MonthlyTotalDto(
    val month: String,   // "2024-01"
    val total: String,
)

@JsonClass(generateAdapter = true)
data class StoreBreakdownDto(
    val store: String,
    val total: String,
    val count: Int,
)

@JsonClass(generateAdapter = true)
data class ImportResponseDto(
    val id: String,
    val store: String,
    val date: String,
    val totalGross: String,
    val itemCount: Int,
)

@JsonClass(generateAdapter = true)
data class ErrorDto(
    val error: String,
)
