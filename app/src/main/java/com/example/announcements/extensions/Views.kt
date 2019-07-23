package com.example.announcements.extensions

import android.view.View
import com.glide.slider.library.Animations.DescriptionAnimation
import com.glide.slider.library.SliderLayout
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun Boolean.toVisibleOrInvisible(): Int {
    return if (this) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}

fun Boolean.toVisibleOrGone(): Int {
    return if (this) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

fun SliderLayout.setupDefault() {
    this.setPresetTransformer(SliderLayout.Transformer.Accordion)

    this.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
    this.setCustomAnimation(DescriptionAnimation())
    this.setDuration(SLIDER_ANIMATION_DURATION_DEFAULT)
}

private const val SLIDER_ANIMATION_DURATION_DEFAULT: Long = 4000L

private const val CLICK_DELAY: Long = 500L

fun Observable<Unit>.preventDoubleClick(): Observable<Unit> {
    return this.throttleFirst(CLICK_DELAY, TimeUnit.MILLISECONDS)
}