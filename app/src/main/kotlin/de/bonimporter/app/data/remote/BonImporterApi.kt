package de.bonimporter.app.data.remote

import de.bonimporter.app.data.remote.model.ImportResponseDto
import de.bonimporter.app.data.remote.model.ReceiptDto
import de.bonimporter.app.data.remote.model.ReceiptsPageDto
import de.bonimporter.app.data.remote.model.StatsDto
import okhttp3.MultipartBody
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface BonImporterApi {

    @GET("api/receipts")
    suspend fun getReceipts(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20,
        @Query("store") store: String? = null,
        @Query("from") from: String? = null,
        @Query("to") to: String? = null,
        @Query("q") search: String? = null,
    ): ReceiptsPageDto

    @GET("api/receipts/{id}")
    suspend fun getReceipt(@Path("id") id: String): ReceiptDto

    @DELETE("api/receipts/{id}")
    suspend fun deleteReceipt(@Path("id") id: String)

    @GET("api/stats")
    suspend fun getStats(): StatsDto

    @Multipart
    @POST("api/import")
    suspend fun importPdfs(
        @Part files: List<MultipartBody.Part>,
    ): List<ImportResponseDto>
}
