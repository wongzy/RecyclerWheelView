package cn.wongzhenyu.recyclerwheelview

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.ViewTreeObserver
import androidx.core.view.doOnPreDraw
import androidx.recyclerview.widget.RecyclerView

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2019-12-29
 **/
class SingleRecyclerWheelView : RecyclerView {

    private var wheelSelectedItemTextColor = -1
    private var wheelSelectedItemTextSize = -1
    private var wheelSelectedItemBackground: Drawable? = null
    private var wheelNormalTextSize = -1
    private var wheelNormalTextColor = -1
    private var wheelItemInterval = -1
    private var wheelNormalItemBackground: Drawable? = null

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
        val attrs =
            context.obtainStyledAttributes(attributeSet, R.styleable.SingleRecyclerWheelView)
        wheelSelectedItemTextColor = attrs.getColor(
            R.styleable.SingleRecyclerWheelView_wheelSelectedItemTextColor,
            resources.getColor(R.color.default_wheelSelectedItemTextColor)
        )
        wheelSelectedItemTextSize = attrs.getDimensionPixelSize(
            R.styleable.SingleRecyclerWheelView_wheelSelectedTextSize,
            sp2px(15.5f).toInt()
        )
        wheelSelectedItemBackground = attrs.getDrawable(
            R.styleable.SingleRecyclerWheelView_wheelSelectedItemBackground
        )
        wheelNormalTextSize = attrs.getDimensionPixelSize(
            R.styleable.SingleRecyclerWheelView_wheelNormalTextSize,
            sp2px(13.5f).toInt()
        )
        wheelNormalTextColor = attrs.getColor(
            R.styleable.SingleRecyclerWheelView_wheelNormalTextColor,
            resources.getColor(R.color.default_wheelNormalTextColor)
        )
        wheelItemInterval = attrs.getDimensionPixelSize(
            R.styleable.SingleRecyclerWheelView_wheelNormalTextSize,
            dp2px(15f).toInt()
        )
        wheelNormalItemBackground = attrs.getDrawable(
            R.styleable.SingleRecyclerWheelView_wheelNormalItemBackground
        )
        attrs.recycle()
        TODO("init layout attributes")

    }
}