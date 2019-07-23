package com.example.announcements.presentation.base.decorations

import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

private const val OFFSET_IN_DP: Float = 16f

class BottomItemDecoration(
    context: Context
) : RecyclerView.ItemDecoration() {

    private val mOffset: Int = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        OFFSET_IN_DP,
        context.resources.displayMetrics
    ).toInt()


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val itemPosition = parent.getChildAdapterPosition(view)

        if (itemPosition == 0) {
            outRect.top = mOffset
        }
    }
}