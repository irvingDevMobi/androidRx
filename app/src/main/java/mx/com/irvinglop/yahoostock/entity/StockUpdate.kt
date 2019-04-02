package mx.com.irvinglop.yahoostock.entity

import java.io.Serializable
import java.math.BigDecimal
import java.util.*

class StockUpdate(
        val stockSymbol: String,
        var price: BigDecimal,
        var date: Date
) : Serializable
