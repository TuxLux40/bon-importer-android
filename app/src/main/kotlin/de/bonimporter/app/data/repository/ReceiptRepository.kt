package de.bonimporter.app.data.repository

import de.bonimporter.app.data.model.Receipt
import de.bonimporter.app.data.model.ReceiptsPage
import de.bonimporter.app.data.model.Stats
import okhttp3.MultipartBody

interface ReceiptRepository {
    suspend fun getReceipts(
        page: Int = 1,
        limit: Int = 20,
        store: String? = null,
        from: String? = null,
        to: String? = null,
        search: String? = null,
    ): ReceiptsPage

    suspend fun getReceipt(id: String): Receipt

    suspend fun deleteReceipt(id: String)

    suspend fun getStats(): Stats

    suspend fun importPdfs(parts: List<MultipartBody.Part>): Int  // returns count imported
}
