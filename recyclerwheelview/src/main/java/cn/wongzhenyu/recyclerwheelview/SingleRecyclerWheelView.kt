package cn.wongzhenyu.recyclerwheelview

import android.content.Context
import android.util.AttributeSet

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2019-12-29
 **/
class SingleRecyclerWheelView : RecyclerWheelView {

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet)

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )

}