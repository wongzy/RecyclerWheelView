package cn.wongzhenyu.recyclerwheelview

import android.content.Context
import android.util.AttributeSet

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2019-12-29
 **/
class SingleRecyclerWheelView : RecyclerWheelView {

    private lateinit var recyclerWheelViewItemInfo: RecyclerWheelViewItemInfo


    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        init(context, attributeSet)
    }

    constructor(context: Context) : super(context)

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
        val wheelSelectedItemTextColor = attrs.getColor(
            R.styleable.SingleRecyclerWheelView_wheelSelectedItemTextColor,
            resources.getColor(R.color.default_wheelSelectedItemTextColor)
        )
        val wheelSelectedItemTextSize = attrs.getDimensionPixelSize(
            R.styleable.SingleRecyclerWheelView_wheelSelectedTextSize,
            sp2px(15.5f).toInt()
        )
        val wheelSelectedItemBackground = attrs.getDrawable(
            R.styleable.SingleRecyclerWheelView_wheelSelectedItemBackground
        )
        val wheelNormalTextSize = attrs.getDimensionPixelSize(
            R.styleable.SingleRecyclerWheelView_wheelNormalTextSize,
            sp2px(13.5f).toInt()
        )
        val wheelNormalTextColor = attrs.getColor(
            R.styleable.SingleRecyclerWheelView_wheelNormalTextColor,
            resources.getColor(R.color.default_wheelNormalTextColor)
        )
        val wheelItemInterval = attrs.getDimensionPixelSize(
            R.styleable.SingleRecyclerWheelView_wheelNormalTextSize,
            dp2px(15f).toInt()
        )
        val wheelNormalItemBackground = attrs.getDrawable(
            R.styleable.SingleRecyclerWheelView_wheelNormalItemBackground
        )
        recyclerWheelViewItemInfo = RecyclerWheelViewItemInfo(
            wheelSelectedItemTextColor,
            wheelSelectedItemTextSize,
            wheelSelectedItemBackground,
            wheelNormalTextSize,
            wheelNormalTextColor,
            wheelItemInterval,
            wheelNormalItemBackground
        )
        attrs.recycle()
    }

}