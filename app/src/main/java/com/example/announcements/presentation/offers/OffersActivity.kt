package com.example.announcements.presentation.offers

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.announcements.R
import com.example.announcements.domain.contracts.IOffersContract
import com.example.announcements.presentation.base.decorations.BottomItemDecoration
import com.example.announcements.presentation.base.views.BaseActivity
import com.example.announcements.presentation.offers.list.OfferVM
import com.example.announcements.presentation.offers.list.OffersAdapter
import kotlinx.android.synthetic.main.activity_offers.*
import me.aartikov.alligator.annotations.RegisterScreen

@RegisterScreen(OffersScreen::class)
class OffersActivity : BaseActivity<IOffersContract.IOffersViewModel, OffersState>(), IOffersContract.IOffersView {
    override val layoutId: Int = R.layout.activity_offers

    private val adapter = OffersAdapter()

    override fun setupViewModel() {
        viewModel = getViewModel<OffersViewModel, OffersScreen>()
    }

    override fun setupUI() {
        super.setupUI()

        setupRecyclerView()
    }

    override fun subscribeOnStateChanges(state: OffersState) {
        super.subscribeOnStateChanges(state)

        registerNonNullObserver(state.networkState) {
            adapter.setNetworkState(it)

            if (!it.msg.isNullOrEmpty()) {
                showErrorDialog(getString(R.string.error_title), it.msg)
            }
        }

        registerNonNullObserver(state.offersPagedList) {
            adapter.submitList(it)
        }
    }

    override fun itemClicked(item: OfferVM) {
        viewModel?.eventsSubject?.onNext(OffersEvents.OfferPressedEvent(item))
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_offers.layoutManager = layoutManager
        rv_offers.addItemDecoration(BottomItemDecoration(this))
        rv_offers.adapter = adapter
        adapter.itemClickListener = this@OffersActivity
    }
}