package mx.com.irvinglop.yahoostock

import android.graphics.Color
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.stock_item.view.*
import mx.com.irvinglop.yahoostock.entity.StockUpdate
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

class StockDataAdapter : RecyclerView.Adapter<StockDataAdapter.StockUpdateViewHolder>() {

    private val data = ArrayList<StockUpdate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockUpdateViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.stock_item, parent, false)
        return StockUpdateViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: StockUpdateViewHolder, position: Int) {
        val stockInfo = data[position]
        holder.stockSymbol?.text = stockInfo.stockSymbol
        holder.setPrice(stockInfo.price)
        holder.setDate(stockInfo.date)
    }

    fun add(stock: StockUpdate) {
        val indexStockFound = data.indexOfFirst { it.stockSymbol == stock.stockSymbol }
        if (indexStockFound < 0) {
            data.add(stock)
            notifyItemInserted(data.size - 1)
        } else {
            data[indexStockFound] = stock
            notifyItemChanged(indexStockFound)
        }
    }

    class StockUpdateViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val stockSymbol: TextView? = view.stockItemSymbol
        private val stockPrice: TextView? = view.stockItemPrice
        private val stockDate: TextView? = view.stockItemDate

        fun setPrice(price: BigDecimal) {
            val value = price.toFloat()
            stockPrice?.text = PRICE_FORMAT.format(value)
            stockPrice?.setTextColor(when {
                                         value > 0 -> Color.GREEN
                                         value < 0 -> Color.RED
                                         else -> Color.GRAY
                                     })
        }

        fun setDate(date: Date) {
            stockDate?.text = DateFormat.format("yyyy-MM-dd hh:mm:ss", date)
        }

        companion object {
            val PRICE_FORMAT = DecimalFormat("#0.00")
        }
    }
}
