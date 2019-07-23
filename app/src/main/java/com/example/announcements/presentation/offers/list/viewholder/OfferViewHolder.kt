package com.example.announcements.presentation.offers.list.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.announcements.R
import com.example.announcements.extensions.gone
import com.example.announcements.extensions.preventDoubleClick
import com.example.announcements.extensions.setupDefault
import com.example.announcements.extensions.visible
import com.example.announcements.presentation.base.listeners.IItemClickListener
import com.example.announcements.presentation.offers.list.OfferVM
import com.glide.slider.library.SliderLayout
import com.glide.slider.library.SliderTypes.DefaultSliderView
import com.jakewharton.rxbinding2.view.clicks

class OfferViewHolder(
    view: View,
    private val itemClickListener: IItemClickListener<OfferVM>?
) : RecyclerView.ViewHolder(view) {
    private val imageSlider = view.findViewById<SliderLayout>(R.id.image_slider)
    private val tvAddress = view.findViewById<TextView>(R.id.tv_address)
    private val tvRooms = view.findViewById<TextView>(R.id.tv_rooms)
    private val tvFloors = view.findViewById<TextView>(R.id.tv_floors)
    private val tvPrice = view.findViewById<TextView>(R.id.tv_price)
    private val llPlaceholder = view.findViewById<LinearLayout>(R.id.ll_placeholder)

    private var offer: OfferVM? = null

    init {
        imageSlider.setupDefault()
    }

    fun bind(offer: OfferVM?) {
        this.offer = offer

        offer?.let { offerVM ->
            tvAddress.text = offerVM.address
            tvRooms.text = offerVM.rooms.toString()
            tvFloors.text = offerVM.floors
            tvPrice.text = offerVM.price

            itemView.clicks()
                .preventDoubleClick()
                .subscribe {
                    itemClickListener?.itemClicked(offerVM)
                }

            bindPhotos(offerVM.photos)
        }
    }

    private fun bindPhotos(photos: List<String>) {
        if (photos.isNotEmpty()) {
            imageSlider.visible()
            llPlaceholder.gone()
            for (url in photos) {
                val sliderView = DefaultSliderView(this.itemView.context)
                sliderView.image(url)

                imageSlider.addSlider(sliderView)

            }
        } else {
            imageSlider.gone()
            llPlaceholder.visible()
        }
    }

    companion object {
        fun create(parent: ViewGroup, itemClickListener: IItemClickListener<OfferVM>?): OfferViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.offer_item, parent, false)
            return OfferViewHolder(view, itemClickListener)
        }
    }
}