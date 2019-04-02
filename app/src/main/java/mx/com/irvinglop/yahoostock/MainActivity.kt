package mx.com.irvinglop.yahoostock

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*

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

        Observable.just("Alphabet", "Apple", "Twitter")
                .subscribe { text -> stockDataAdapter.add(text) }
    }
}
