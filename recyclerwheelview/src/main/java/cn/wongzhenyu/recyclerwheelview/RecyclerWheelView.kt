package cn.wongzhenyu.recyclerwheelview

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

class RecyclerWheelView : RecyclerView {

    private var wheelSelectedItemTextColor = -1
    private var wheelSelectedItemTextSize = -1
    private var wheelSelectedItemBackground : Drawable? = null
    private var wheelNormalTextSize = -1
    private var wheelNormalTextColor = -1
    private var wheelItemInterval = -1
    private var wheelNormalItemBackground : Drawable? = null

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        init(context, attributeSet)
    }

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        init(context, attributeSet)
    }

    private fun init(context: Context, attributeSet: AttributeSet?) {
        val attrs = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerWheelView)
        wheelSelectedItemTextColor = attrs.getColor(
            R.styleable.RecyclerWheelView_wheelSelectedItemTextColor,
            resources.getColor(R.color.default_wheelSelectedItemTextColor)
        )
        wheelSelectedItemTextSize = attrs.getDimensionPixelSize(
            R.styleable.RecyclerWheelView_wheelSelectedTextSize,
            sp2px(15.5f).toInt()
        )
        wheelSelectedItemBackground = attrs.getDrawable(
            R.styleable.RecyclerWheelView_wheelSelectedItemBackground
        )
        wheelNormalTextSize = attrs.getDimensionPixelSize(
            R.styleable.RecyclerWheelView_wheelNormalTextSize,
            sp2px(13.5f).toInt()
        )
        wheelNormalTextColor = attrs.getColor(
            R.styleable.RecyclerWheelView_wheelNormalTextColor,
            resources.getColor(R.color.default_wheelNormalTextColor)
        )
        wheelItemInterval = attrs.getDimensionPixelSize(
            R.styleable.RecyclerWheelView_wheelNormalTextSize,
            dp2px(15f).toInt()
        )
        wheelNormalItemBackground = attrs.getDrawable(
            R.styleable.RecyclerWheelView_wheelNormalItemBackground
        )
        attrs.recycle()
    }
}