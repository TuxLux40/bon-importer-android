package de.bonimporter.app.data.repository

import de.bonimporter.app.data.mapper.toDomain
import de.bonimporter.app.data.model.Receipt
import de.bonimporter.app.data.model.ReceiptsPage
import de.bonimporter.app.data.model.Stats
import de.bonimporter.app.data.remote.BonImporterApi
import okhttp3.MultipartBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReceiptRepositoryImpl @Inject constructor(
    private val api: BonImporterApi,
) : ReceiptRepository {

    override suspend fun getReceipts(
        page: Int,
        limit: Int,
        store: String?,
        from: String?,
        to: String?,
        search: String?,
    ): ReceiptsPage = api.getReceipts(page, limit, store, from, to, search).toDomain()

    override suspend fun getReceipt(id: String): Receipt =
        api.getReceipt(id).toDomain()

    override suspend fun deleteReceipt(id: String) =
        api.deleteReceipt(id)

    override suspend fun getStats(): Stats =
        api.getStats().toDomain()

    override suspend fun importPdfs(parts: List<MultipartBody.Part>): Int =
        api.importPdfs(parts).size
}
