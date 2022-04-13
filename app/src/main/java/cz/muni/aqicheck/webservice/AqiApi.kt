package cz.muni.aqicheck.webservice

import cz.muni.aqicheck.webservice.response.AqiDetailResponse
import cz.muni.aqicheck.webservice.response.AqiListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AqiApi {

    @GET("search/")
    fun getSearchAqiByName(
        @Query("keyword") keyboard: String,
        @Query("token") token: String,
    ): Call<AqiListResponse>

    @GET("feed/@{id}/")
    fun getSearchAqiById(
        @Path("id") id: Long,
        @Query("token") token: String,
    ): Call<AqiDetailResponse>
}