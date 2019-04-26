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
        val quote: List<YahooStockQuote>
)

data class YahooStockQuote(
        val symbol: String,
        @SerializedName("Name")
        val name: String,
        @SerializedName("LastTradePriceOnly")
        val lastTradePriceOnly: BigDecimal,
        @SerializedName("DaysLow")
        val daysLow: BigDecimal,
        @SerializedName("DaysHigh")
        val daysHigh: BigDecimal,
        @SerializedName("Volume")
        val volume: String
)
