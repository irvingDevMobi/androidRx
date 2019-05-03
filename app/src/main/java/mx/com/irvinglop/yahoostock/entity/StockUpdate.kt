package mx.com.irvinglop.yahoostock.entity

import mx.com.irvinglop.yahoostock.data.responses.Stock
import java.io.Serializable
import java.math.BigDecimal
import java.util.*

data class StockUpdate(
        val stockSymbol: String,
        var price: BigDecimal,
        var date: Date
) : Serializable {

    companion object {
        fun create(stock: Stock): StockUpdate? {
            return if (stock.symbol == null || stock.price == null) null
            else StockUpdate(stock.symbol,
                             stock.price,
                             Date())

        }
    }
}
