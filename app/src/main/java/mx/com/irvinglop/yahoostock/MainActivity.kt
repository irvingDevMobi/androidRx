package mx.com.irvinglop.yahoostock

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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
        Log.e(TAG, "*******************************")
        Observable.just("firstItem", "SecondItem")
                .doOnNext { Log.d(TAG, "onNext: $it Thread:" + Thread.currentThread().name) }
                .subscribe {
                    Log.d(TAG, "subscribe: $it Thread" + Thread.currentThread().name)
                    Log.e(TAG, "*******************************")
                }
        Observable.just("firstItem2", "SecondItem2")
                .subscribeOn(Schedulers.io())
                .doOnNext { Log.d(TAG, "onNext: $it Thread:" + Thread.currentThread().name) }
                .subscribe {
                    Log.d(TAG, "subscribe: $it Thread" + Thread.currentThread().name)
                    Log.e(TAG, "*******************************")
                }
        Observable.just("firstItem3", "SecondItem3")
                .subscribeOn(Schedulers.io())
                .doOnNext { Log.d(TAG, "onNext: $it Thread:" + Thread.currentThread().name) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d(TAG, "subscribe: $it Thread" + Thread.currentThread().name)
                    Log.e(TAG, "*******************************")
                }
        Observable.just("firstItem4", "SecondItem4")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext { Log.d(TAG, "onNext: $it Thread:" + Thread.currentThread().name) }
                .subscribe {
                    Log.d(TAG, "subscribe: $it Thread" + Thread.currentThread().name)
                }
    }

    companion object {
        const val TAG = "YahooApp"
    }
}
