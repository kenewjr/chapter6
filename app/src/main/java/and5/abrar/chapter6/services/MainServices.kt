package and5.abrar.chapter6.services

import and5.abrar.chapter6.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_services.*

class MainServices : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_services)
        btnPlay.setOnClickListener {
            startService(Intent(this,ServicePlayer::class.java))
        }
        btnStop.setOnClickListener {
            stopService(Intent(this,ServicePlayer::class.java))
        }
    }
}