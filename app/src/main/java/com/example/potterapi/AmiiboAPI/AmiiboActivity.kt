package com.example.potterapi.AmiiboAPI

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.potterapi.R
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AmiiboActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_amiibo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch {
//        Ambil Repo
            val respon = RetrofitAPI.amiiboHeadService.getMario("mario")
            val listRespon = respon.amiibo
            for (item in listRespon){
                Log.d("series", item.amiiboSeries)

            val recyclerView = findViewById<RecyclerView>(R.id.recycle)
                recyclerView.layoutManager = LinearLayoutManager(this@AmiiboActivity)
                recyclerView.adapter = AmiiboAdapter(listRespon)
            }
        }
    }
}

object RetrofitAPI {
    private const val BASE_URL = "https://www.amiiboapi.com/api/"

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val amiiboHeadService: AmiiboHeadService by lazy {
        instance.create(AmiiboHeadService::class.java)
    }
}