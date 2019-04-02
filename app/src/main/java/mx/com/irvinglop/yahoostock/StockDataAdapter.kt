package mx.com.irvinglop.yahoostock

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.stock_item.view.*

class StockDataAdapter : RecyclerView.Adapter<StockDataAdapter.StockUpdateViewHolder>() {

    private val data = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockUpdateViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.stock_item, parent, false)
        return StockUpdateViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: StockUpdateViewHolder, position: Int) {
        holder.stockSymbol.text = data[position]
    }

    fun add(stockSymbol: String) {
        data.add(stockSymbol)
        notifyItemInserted(data.size - 1)
    }

    class StockUpdateViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val stockSymbol: TextView = view.stockItemSymbol
    }
}
