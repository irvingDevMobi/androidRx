package mx.com.irvinglop.yahoostock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Observable.just("Hello Please Use this app responsibly!")
                .subscribe(object : Consumer<String> {
                    override fun accept(text: String?) {
                        welcomeTextView.text = text
                    }
                }
                )
    }
}
