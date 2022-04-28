package and5.abrar.chapter6.kedua

import and5.abrar.chapter6.R
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main_async_task.*
import kotlinx.android.synthetic.main.activity_main_coroutines.*
import kotlinx.coroutines.*

class MainCoroutines : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_async_task)
            contohcoroutines2()
    }
    fun contohcoroutines2(){
        GlobalScope.launch {
            CoroutineScope(Dispatchers.Main).launch {
//                initext.text = "Hello world"
                btnHitungBb.setOnClickListener {
                    val berat = inBb.text.toString().toInt()
                    val tinggi = inTinggi.text.toString().toFloat()
                    val bmi = (berat / (tinggi * tinggi))
                    var output = ""
                    if (bmi < 18.5) {
                        output = "Kurus"
                    } else if (bmi > 18.5 && bmi < 24.9) {
                        output = "Normal"
                    } else if (bmi > 25 && bmi < 29.9) {
                        output = "Overweight"
                    } else if (bmi >= 30) {
                        output = "Obesitas"
                    }
                    tvhasil.text = output
                }
            }
            CoroutineScope(Dispatchers.IO).launch {
                Log.d(TAG,"dispacher io")
            }
            CoroutineScope(Dispatchers.Default).launch {
                Log.d(TAG,"dispacher default")
            }
        }
    }
    suspend fun  doText(): String{
        return "Hello World"
    }
    fun contohcoroutines(){
        GlobalScope.launch {
            delay(2000)
           initext.text = "halo abrar"
        }
    }
//    private  suspend fun getString(s:String):String{
//        delay(1000)
//        return s
//    }
//    suspend fun hasil():String{
//        delay(2000)
//        val a = initext.setText("helo abrar")
//        return a.toString()
//    }
}