package and5.abrar.chapter6

import and5.abrar.chapter6.pertama.icip1
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        contohThreadSatu()
//        contohHandler()
        handlerthread()
        contohHT()
    }
    fun contohThreadSatu(){
        Thread(Runnable {
            btnChange.setOnClickListener { tv1.post(Runnable { tv1.text = "Hello kamu abrar" }) }
            tv1.post(Runnable { tv1.text = " Hello WOrld" })
            tv2.postDelayed(Runnable { tv2.text = "welcome , abrar" },2000)
        }).start()
    }
    fun contohHandler(){
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
        startActivity(Intent(this,icip1::class.java))
        },3000)
        Handler(Looper.getMainLooper()).post(Runnable { tv2.setText("hola") })
    }
    fun handlerthread(){
        val han = object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val pesan2 = msg.obj as String
                tv2.text = pesan2
            }
        }
        Thread(Runnable {
            val a = "Contoh Handler Thread"
            val pesan = Message.obtain()
            pesan.obj = a
            pesan.target = han
            pesan.sendToTarget()
        }).start()
    }
    fun contohHT(){
        val targethandler = object :Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val a = msg.obj as String
                tv1.text = a
            }
        }
        Thread(Runnable {
            val b = Message.obtain()
            b.obj = "qwerty"
            b.target = targethandler
            b.sendToTarget()
        }).start()
    }
}