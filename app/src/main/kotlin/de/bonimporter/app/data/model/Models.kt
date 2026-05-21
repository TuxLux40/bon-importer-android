package de.bonimporter.app.data.model

import java.math.BigDecimal
import java.time.Instant

data class Receipt(
    val id: String,
    val store: String,
    val storeAddress: String?,
    val date: Instant,
    val bonNumber: String?,
    val totalGross: BigDecimal,
    val totalNet: BigDecimal?,
    val totalTax: BigDecimal?,
    val paymentMethod: String?,
    val importSource: String,
    val sourceFile: String?,
    val items: List<LineItem> = emptyList(),
    val taxEntries: List<TaxEntry> = emptyList(),
)

data class LineItem(
    val id: String,
    val name: String,
    val priceGross: BigDecimal,
    val taxCategory: String,
    val isDiscount: Boolean,
    val isDeposit: Boolean,
    val quantity: BigDecimal?,
    val quantityUnit: String?,
    val unitPrice: BigDecimal?,
    val paybackEligible: Boolean,
)

data class TaxEntry(
    val id: String,
    val category: String,
    val rate: BigDecimal,
    val net: BigDecimal,
    val tax: BigDecimal,
    val gross: BigDecimal,
)

data class Stats(
    val totalSpend: BigDecimal,
    val receiptCount: Int,
    val avgPerReceipt: BigDecimal,
    val topItems: List<TopItem>,
    val monthlyTotals: List<MonthlyTotal>,
    val storeBreakdown: List<StoreBreakdown>,
)

data class TopItem(
    val name: String,
    val count: Int,
    val totalSpend: BigDecimal,
)

data class MonthlyTotal(
    val month: String,
    val total: BigDecimal,
)

data class StoreBreakdown(
    val store: String,
    val total: BigDecimal,
    val count: Int,
)

data class ReceiptsPage(
    val receipts: List<Receipt>,
    val total: Int,
    val page: Int,
    val limit: Int,
    val totalPages: Int,
)
