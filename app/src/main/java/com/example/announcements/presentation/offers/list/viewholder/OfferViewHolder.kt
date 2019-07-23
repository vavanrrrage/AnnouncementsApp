package com.example.announcements.presentation.offers.list.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.announcements.R
import com.example.announcements.extensions.gone
import com.example.announcements.extensions.setupDefault
import com.example.announcements.extensions.visible
import com.example.announcements.presentation.offers.list.OfferVM
import com.glide.slider.library.SliderLayout
import com.glide.slider.library.SliderTypes.DefaultSliderView

class OfferViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imageSlider = view.findViewById<SliderLayout>(R.id.image_slider)
    private val tvAddress = view.findViewById<TextView>(R.id.tv_address)
    private val tvRooms = view.findViewById<TextView>(R.id.tv_rooms)
    private val tvFloors = view.findViewById<TextView>(R.id.tv_floors)
    private val tvPrice = view.findViewById<TextView>(R.id.tv_price)

    private var offer: OfferVM? = null

    init {
        imageSlider.setupDefault()
    }

    fun bind(offer: OfferVM?) {
        this.offer = offer

        offer?.let {
            tvAddress.text = it.address
            tvRooms.text = it.rooms.toString()
            tvFloors.text = it.floors
            tvPrice.text = it.price

            bindPhotos(it.photos)
        }
    }

    private fun bindPhotos(photos: List<String>) {
        // todo add stub (placeholder)
        if (photos.isNotEmpty()) {
            imageSlider.visible()
            for (url in photos) {
                val sliderView = DefaultSliderView(this.itemView.context)
                sliderView.image(url)

                imageSlider.addSlider(sliderView)

            }
        } else {
            imageSlider.gone()
        }
    }

    companion object {
        fun create(parent: ViewGroup): OfferViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.offer_item, parent, false)
            return OfferViewHolder(view)
        }
    }
}