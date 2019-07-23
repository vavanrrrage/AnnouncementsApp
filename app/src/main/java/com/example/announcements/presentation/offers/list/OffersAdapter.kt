package com.example.announcements.presentation.offers.list

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.announcements.R
import com.example.announcements.data.network.NetworkState
import com.example.announcements.presentation.offers.list.viewholder.NetworkStateViewHolder
import com.example.announcements.presentation.offers.list.viewholder.OfferViewHolder

class OffersAdapter : PagedListAdapter<OfferVM, RecyclerView.ViewHolder>(POST_COMPARATOR) {
    private var networkState: NetworkState? = null
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.offer_item -> (holder as OfferViewHolder).bind(getItem(position))
            R.layout.network_state_item -> (holder as NetworkStateViewHolder)
        }
    }

//    override fun onBindViewHolder(
//        holder: RecyclerView.ViewHolder,
//        position: Int,
//        payloads: MutableList<Any>) {
//        if (payloads.isNotEmpty()) {
//            val item = getItem(position)
//            (holder as RedditPostViewHolder).updateScore(item)
//        } else {
//            onBindViewHolder(holder, position)
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.offer_item -> OfferViewHolder.create(parent)
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
        //        private val PAYLOAD_SCORE = Any()
        val POST_COMPARATOR = object : DiffUtil.ItemCallback<OfferVM>() {
            override fun areContentsTheSame(oldItem: OfferVM, newItem: OfferVM): Boolean =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: OfferVM, newItem: OfferVM): Boolean =
                oldItem.id == newItem.id

//            override fun getChangePayload(oldItem: OfferVM, newItem: OfferVM): Any? {
//                return if (sameExceptScore(oldItem, newItem)) {
//                    PAYLOAD_SCORE
//                } else {
//                    null
//                }
//            }
        }
//
//        private fun sameExceptScore(oldItem: RedditPost, newItem: RedditPost): Boolean {
//            // DON'T do this copy in a real app, it is just convenient here for the demo :)
//            // because reddit randomizes scores, we want to pass it as a payload to minimize
//            // UI updates between refreshes
//            return oldItem.copy(score = newItem.score) == newItem
//        }
    }
}