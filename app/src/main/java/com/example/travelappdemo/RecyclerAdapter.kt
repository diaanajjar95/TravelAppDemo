package com.example.travelappdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val countriesList: ArrayList<Country>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CountryVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CountryVH).bind(country = countriesList[position],onItemClickListener)
    }

    override fun getItemCount(): Int = countriesList.size

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }
}