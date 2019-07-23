package com.example.announcements.presentation.details

import com.example.announcements.R
import com.example.announcements.domain.contracts.IDetailsContract
import com.example.announcements.extensions.gone
import com.example.announcements.extensions.setupDefault
import com.example.announcements.extensions.visible
import com.example.announcements.presentation.base.views.BaseActivity
import com.glide.slider.library.SliderTypes.DefaultSliderView
import kotlinx.android.synthetic.main.layout_offer.*
import me.aartikov.alligator.annotations.RegisterScreen

@RegisterScreen(DetailsScreen::class)
class DetailsActivity : BaseActivity<IDetailsContract.IDetailsViewModel, DetailsState>(),
    IDetailsContract.IDetailsView {
    override val layoutId: Int = R.layout.activity_details

    override fun setupUI() {
        super.setupUI()

        image_slider.setupDefault()
    }

    override fun setupViewModel() {
        viewModel = getViewModel<DetailsViewModel, DetailsScreen>()
    }

    override fun subscribeOnStateChanges(state: DetailsState) {
        super.subscribeOnStateChanges(state)

        registerNonNullObserver(state.address) {
            tv_address.text = it
        }

        registerNonNullObserver(state.floors) {
            tv_floors.text = it
        }

        registerNonNullObserver(state.photoUrls) {
            if (it.isNotEmpty()) {
                image_slider.visible()
                ll_placeholder.gone()
                for (url in it) {
                    val sliderView = DefaultSliderView(this)
                    sliderView.image(url)

                    image_slider.addSlider(sliderView)

                }
            } else {
                image_slider.gone()
                ll_placeholder.visible()
            }
        }

        registerNonNullObserver(state.price) {
            tv_price.text = it
        }

        registerNonNullObserver(state.rooms) {
            tv_rooms.text = it
        }

        registerNonNullObserver(state.plan) {
            tv_plan.text = it
        }
    }
}