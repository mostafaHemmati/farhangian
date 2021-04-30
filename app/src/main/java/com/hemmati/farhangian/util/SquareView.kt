package com.hemmati.farhangian.util

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

class SquareView(
    context: Context,
    attrs: AttributeSet
) : LinearLayout(context, attrs, 0) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}