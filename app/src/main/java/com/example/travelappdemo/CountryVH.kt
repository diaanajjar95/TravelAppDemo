package com.example.travelappdemo

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_country.view.*

class CountryVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val rootView = itemView.item_country_rootView
    private val name = itemView.item_country_nameTV
    private val city = itemView.item_country_cityTV
    private val numberOfDays = itemView.item_country_numberOfDaysTv
    private val price = itemView.item_country_priceTv
    private val ratingBar = itemView.item_country_ratingBar
    private val imageView = itemView.item_country_imageView

    fun bind(country: Country, onItemClickListener: OnItemClickListener) {
        name.text = country.name
        city.text = country.city
        numberOfDays.text = country.numberOfDays
        price.text = country.price
        ratingBar.rating = country.rating.toFloat()

        Glide.with(itemView).load(country.image).into(imageView)

        rootView.setOnClickListener {
            onItemClickListener.onIteClick(country, adapterPosition)
        }
    }

}