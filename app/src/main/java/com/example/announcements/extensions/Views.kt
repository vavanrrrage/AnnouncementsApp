package com.example.announcements.extensions

import android.view.View
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


private const val CLICK_DELAY: Long = 500L

fun Observable<Unit>.preventDoubleClick(): Observable<Unit> {
    return this.throttleFirst(CLICK_DELAY, TimeUnit.MILLISECONDS)
}