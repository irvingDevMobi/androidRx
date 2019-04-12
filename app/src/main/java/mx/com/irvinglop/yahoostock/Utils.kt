package mx.com.irvinglop.yahoostock

import android.util.Log

const val TAG = "YahooApp"

fun log(stage: String, item: String = "") {
    Log.d(TAG, "$stage: $item :" + Thread.currentThread().name)
}

fun log(throwable: Throwable) {
    Log.e(TAG, "ERROR", throwable)
}
