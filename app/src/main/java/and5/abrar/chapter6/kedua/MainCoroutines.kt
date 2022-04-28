package and5.abrar.chapter6.kedua

import and5.abrar.chapter6.R
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main_coroutines.*
import kotlinx.coroutines.*

class MainCoroutines : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_coroutines)
            contohcoroutines()
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