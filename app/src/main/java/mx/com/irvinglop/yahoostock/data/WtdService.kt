package mx.com.irvinglop.yahoostock.data

import io.reactivex.Single
import mx.com.irvinglop.yahoostock.BuildConfig
import mx.com.irvinglop.yahoostock.data.responses.WtdStockResults
import retrofit2.http.GET
import retrofit2.http.Query

interface WtdService {

    @GET(BuildConfig.STOCKS_RESULTS)
    fun stocksResults(
            @Query("symbol") symbols: String,
            @Query("api_token") token: String
    ): Single<WtdStockResults>
}
