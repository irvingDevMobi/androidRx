package mx.com.irvinglop.yahoostock.data

import io.reactivex.Single
import mx.com.irvinglop.yahoostock.BuildConfig
import mx.com.irvinglop.yahoostock.data.responses.YahooStockResult
import retrofit2.http.GET
import retrofit2.http.Query

interface YahooService {

    @GET(BuildConfig.YAHOO_QUERY)
    fun yahooQuery(
            @Query("q") query: String,
            @Query("env") env: String
    ): Single<YahooStockResult>
}
