package de.bonimporter.app.data.mapper

import de.bonimporter.app.data.model.LineItem
import de.bonimporter.app.data.model.MonthlyTotal
import de.bonimporter.app.data.model.Receipt
import de.bonimporter.app.data.model.ReceiptsPage
import de.bonimporter.app.data.model.Stats
import de.bonimporter.app.data.model.StoreBreakdown
import de.bonimporter.app.data.model.TaxEntry
import de.bonimporter.app.data.model.TopItem
import de.bonimporter.app.data.remote.model.LineItemDto
import de.bonimporter.app.data.remote.model.ReceiptDto
import de.bonimporter.app.data.remote.model.ReceiptsPageDto
import de.bonimporter.app.data.remote.model.StatsDto
import de.bonimporter.app.data.remote.model.TaxEntryDto
import java.math.BigDecimal
import java.time.Instant

fun ReceiptsPageDto.toDomain() = ReceiptsPage(
    receipts = receipts.map { it.toDomain() },
    total = total,
    page = page,
    limit = limit,
    totalPages = totalPages,
)

fun ReceiptDto.toDomain() = Receipt(
    id = id,
    store = store,
    storeAddress = storeAddress,
    date = Instant.parse(date),
    bonNumber = bonNumber,
    totalGross = BigDecimal(totalGross),
    totalNet = totalNet?.let { BigDecimal(it) },
    totalTax = totalTax?.let { BigDecimal(it) },
    paymentMethod = paymentMethod,
    importSource = importSource,
    sourceFile = sourceFile,
    items = items.map { it.toDomain() },
    taxEntries = taxEntries.map { it.toDomain() },
)

fun LineItemDto.toDomain() = LineItem(
    id = id,
    name = name,
    priceGross = BigDecimal(priceGross),
    taxCategory = taxCategory,
    isDiscount = isDiscount,
    isDeposit = isDeposit,
    quantity = quantity?.let { BigDecimal(it) },
    quantityUnit = quantityUnit,
    unitPrice = unitPrice?.let { BigDecimal(it) },
    paybackEligible = paybackEligible,
)

fun TaxEntryDto.toDomain() = TaxEntry(
    id = id,
    category = category,
    rate = BigDecimal(rate),
    net = BigDecimal(net),
    tax = BigDecimal(tax),
    gross = BigDecimal(gross),
)

fun StatsDto.toDomain() = Stats(
    totalSpend = BigDecimal(totalSpend),
    receiptCount = receiptCount,
    avgPerReceipt = BigDecimal(avgPerReceipt),
    topItems = topItems.map { TopItem(it.name, it.count, BigDecimal(it.totalSpend)) },
    monthlyTotals = monthlyTotals.map { MonthlyTotal(it.month, BigDecimal(it.total)) },
    storeBreakdown = storeBreakdown.map { StoreBreakdown(it.store, BigDecimal(it.total), it.count) },
)
