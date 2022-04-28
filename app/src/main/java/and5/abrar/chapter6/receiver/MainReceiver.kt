package and5.abrar.chapter6.receiver

import and5.abrar.chapter6.R
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainReceiver : AppCompatActivity() {
    lateinit var pesawat : AirplaneModeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_receiver)
        pesawat = AirplaneModeReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(pesawat,it)
        }
    }
}