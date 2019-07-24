package com.example.announcements.presentation.offers.list

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.announcements.R
import com.example.announcements.data.network.NetworkState
import com.example.announcements.presentation.base.listeners.IItemClickListener
import com.example.announcements.presentation.offers.list.viewholder.NetworkStateViewHolder
import com.example.announcements.presentation.offers.list.viewholder.OfferViewHolder

class OffersAdapter : PagedListAdapter<OfferVM, RecyclerView.ViewHolder>(POST_COMPARATOR) {
    private var networkState: NetworkState? = null
    var itemClickListener: IItemClickListener<OfferVM>? = null

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.offer_item -> (holder as OfferViewHolder).bind(getItem(position))
            R.layout.network_state_item -> (holder as NetworkStateViewHolder)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.offer_item -> OfferViewHolder.create(parent, itemClickListener)
            R.layout.network_state_item -> NetworkStateViewHolder.create(parent)
            else -> throw IllegalArgumentException("unknown view type $viewType")
        }
    }

    private fun hasExtraRow() = networkState != null && networkState != NetworkState.LOADED

    override fun getItemViewType(position: Int): Int {
        return if (hasExtraRow() && position == itemCount - 1) {
            R.layout.network_state_item
        } else {
            R.layout.offer_item
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasExtraRow()) 1 else 0
    }

    fun setNetworkState(newNetworkState: NetworkState?) {
        val previousState = this.networkState
        val hadExtraRow = hasExtraRow()
        this.networkState = newNetworkState
        val hasExtraRow = hasExtraRow()
        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(super.getItemCount())
            } else {
                notifyItemInserted(super.getItemCount())
            }
        } else if (hasExtraRow && previousState != newNetworkState) {
            notifyItemChanged(itemCount - 1)
        }
    }

    companion object {
        val POST_COMPARATOR = object : DiffUtil.ItemCallback<OfferVM>() {
            override fun areContentsTheSame(oldItem: OfferVM, newItem: OfferVM): Boolean =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: OfferVM, newItem: OfferVM): Boolean =
                oldItem.id == newItem.id
        }
    }
}