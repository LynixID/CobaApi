package com.example.potterapi.AmiiboAPI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.potterapi.R

class AmiiboAdapter (
    private val amiiboList: List<AmiiboItem>
): RecyclerView.Adapter<AmiiboAdapter.AmiiboViewHolder>(){

    class AmiiboViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val gambar: ImageView = view.findViewById(R.id.gambar)
        val series: TextView = view.findViewById(R.id.series)
        val character: TextView = view.findViewById(R.id.character)
        val name: TextView = view.findViewById(R.id.name)
        val type: TextView = view.findViewById(R.id.type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmiiboViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_amiibo, parent, false)
        return AmiiboViewHolder(view)
    }

    override fun onBindViewHolder(holder: AmiiboViewHolder, position: Int) {
        val amiibo = amiiboList[position]

        Glide.with(holder.gambar.context)
            .load(amiibo.image) // URL gambar
            .placeholder(R.drawable.naruto) // Gambar placeholder
            .error(R.drawable.eror) // Gambar jika gagal memuat
            .into(holder.gambar)

        holder.series.text = amiibo.amiiboSeries
        holder.character.text = amiibo.character
        holder.name.text = amiibo.name
        holder.type.text = amiibo.type
    }

    override fun getItemCount(): Int = amiiboList.size
}