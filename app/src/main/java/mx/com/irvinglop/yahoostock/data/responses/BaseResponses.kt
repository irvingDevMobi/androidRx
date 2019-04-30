package mx.com.irvinglop.yahoostock.data.responses

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.util.Date

data class YahooStockResult(
        val query: YahooStockQuery
)

data class YahooStockQuery(
        val count: Int,
        val created: Date,
        val results: YahooStockResults
)

data class YahooStockResults(
        val quote: List<Stock>
)

data class Stock(
        val symbol: String?,
        val name: String?,
        val price: BigDecimal?,
        @SerializedName("day_high")
        val dayHigh: BigDecimal?,
        @SerializedName("day_low")
        val dayLow: BigDecimal?,
        val volume: String?
)
