package mx.com.irvinglop.yahoostock

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*
import mx.com.irvinglop.yahoostock.entity.StockUpdate
import java.math.BigDecimal
import java.util.*

class MainActivity : AppCompatActivity() {

    private val stockDataAdapter by lazy { StockDataAdapter() }
    private val linearLayoutManager by lazy { LinearLayoutManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = stockDataAdapter
        }

        Observable.just(
                StockUpdate("Alphabet", BigDecimal(12.43), Date()),
                StockUpdate("Apple", BigDecimal(645.1), Date()),
                StockUpdate("Twitter", BigDecimal(1.43), Date()))
                .subscribe { text -> stockDataAdapter.add(text) }
    }
}
