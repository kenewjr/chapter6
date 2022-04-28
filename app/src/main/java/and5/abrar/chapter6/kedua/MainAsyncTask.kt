package and5.abrar.chapter6.kedua

import and5.abrar.chapter6.R
import android.app.ProgressDialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_async_task.*

@Suppress("DEPRECATION")
class MainAsyncTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_async_task)
        btnHitungBb.setOnClickListener {
            contohAsyntask().execute()
        }

    }
    inner class contohAsyntask : AsyncTask<Int,Void,String>(){
        lateinit var  pdialog : ProgressDialog
        override fun doInBackground(vararg p0: Int?): String {
            val berat = inBb.text.toString().toInt()
            val tinggi = inTinggi.text.toString().toFloat()
            val bmi = (berat/(tinggi*tinggi))
            var output = ""
            if (bmi<18.5){
                output = "Kurus"
            }else if (bmi>18.5 && bmi<24.9){
                output = "Normal"
            }else if (bmi>25 && bmi<29.9){
                output = "Overweight"
            }else if (bmi>=30){
                output = "Obesitas"
            }
            return  output
        }

        override fun onPreExecute() {
            super.onPreExecute()
            pdialog = ProgressDialog(this@MainAsyncTask)
            pdialog.show()
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            tvhasil.text = result
            pdialog.dismiss()
            inBb.setText("")
            inTinggi.setText("")
        }

    }
}