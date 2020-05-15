package com.example.mahasiswaandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.example.mahasiswaaandroid.R
import kotlinx.android.synthetic.main.activity_tambah.*
import org.json.JSONArray

class Tambah : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

        tambah.setOnClickListener {
            var textViewJudul : String = judul.text.toString()
            var textViewWaktu : String = waktu.text.toString()
            var textViewIsi : String = isi.text.toString()
            var textViewPenulis : String = penulis.text.toString()

            postkeserver(textViewJudul, textViewWaktu, textViewIsi, textViewPenulis)

            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            finish()
        }

        kembali.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun postkeserver(data1:String, data2:String, data3:String, data4:String){
        AndroidNetworking.post("http://192.168.1.31/mahasiswa/insert_data.php")
            .addBodyParameter("judul_berita", data1)
            .addBodyParameter("waktu_berita", data2)
            .addBodyParameter("penulis_berita", data3)
            .addBodyParameter("isi_berita", data4)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(object : JSONArrayRequestListener {
                    override fun onResponse(response: JSONArray) {
                        Log.i("Coba", "Sukses")
                        Toast.makeText(applicationContext, "Berhasil", Toast.LENGTH_LONG).show()
                    }

                    override fun onError(anError: ANError) { // handle error
                        Log.i("_err", anError.toString())
                    }
                })
    }
}
