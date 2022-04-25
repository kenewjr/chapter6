package and5.abrar.chapter6.pertama

import and5.abrar.chapter6.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_icip1.*
import kotlinx.android.synthetic.main.activity_main.*

class icip1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icip1)
        contohThreadSatu()
    }

    fun contohThreadSatu() {
        Thread(Runnable {
            btnHitung.setOnClickListener {
                val nama = etNama.text.toString()
                val umur = etUmur.text.toString()
                val hitung = 2022 - umur.toInt()
                etNama.post(Runnable { result.text = "$nama" })
                etUmur.post(Runnable { result1.text = hitung.toString() })}
        }).start()
    }
}