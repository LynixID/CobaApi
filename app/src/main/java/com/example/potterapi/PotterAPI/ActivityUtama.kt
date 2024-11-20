package com.example.potterapi.PotterAPI

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.potterapi.R
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ActivityUtama : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_utama)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Inisialisasi API
        val api = RetrofitAPI.instance.create(PotterHeadService::class.java)

        lifecycleScope.launch {
//        Ambil Repo
            val listBuku = RetrofitAPI.potterApiService.getBooks("en")

            for (buku in listBuku){
                Log.d("Nama Buku", buku.title)
            }
        }
    }

}

object RetrofitAPI {
    private const val BASE_URL = "https://potterapi-fedeperin.vercel.app/"

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val potterApiService: PotterHeadService by lazy {
        instance.create(PotterHeadService::class.java)
    }
}