package cn.wongzhenyu.recyclerwheelview

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2020-02-05
 **/

abstract class RecyclerWheelView : RecyclerView {
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
    }

    @Deprecated("use setAdapter(adapter: RecyclerWheelViewAdapter<*>?) instead of setAdapter(adapter: Adapter<*>?)")
    override fun setAdapter(adapter: Adapter<*>?) {
        if (adapter !is RecyclerWheelViewAdapter) {
            throw IllegalArgumentException("adapter is not a instance of RecyclerWheelViewAdapter")
        }
        super.setAdapter(adapter)
    }

    fun setAdapter(adapter: RecyclerWheelViewAdapter<*>?) {
        setAdapter(adapter)
    }
}