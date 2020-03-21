package cn.wongzhenyu.recyclerwheelview

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.wongzhenyu.recyclerwheelview.util.logDebug
import cn.wongzhenyu.recyclerwheelview.util.logError

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2020-02-05
 **/

open class RecyclerWheelView : RecyclerView {

    /**
     * all scrolled Y
     */
    protected var pointY = 0
    /**
     * padding item redundant offset Y, we should scroll it before RecyclerWheelView has shown
     */
    private var offsetY : Int = 0
    /**
     * whether need to fix paddding redundant offset in onLayout method
     */
    protected var isMeasureFirst = true

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet)

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )

    @Deprecated(
        "setRecyclerWheelViewAdapter(recyclerWheelViewAdapter: RecyclerWheelViewAdapter<*>?) instead of setAdapter(adapter: Adapter<*>?)"
    )
    override fun setAdapter(adapter: Adapter<ViewHolder>?) {
        logDebug("setAdapter")
        if (adapter !is RecyclerWheelViewAdapter) {
            logError("adapter is not a instance of RecyclerWheelViewAdapter")
            throw IllegalArgumentException("adapter is not a instance of RecyclerWheelViewAdapter")
        }
        layoutManager = LinearLayoutManager(context, VERTICAL, false)
        super.setAdapter(adapter)
    }

    /**
     * set adapter
     */
    open fun setRecyclerWheelViewAdapter(recyclerWheelViewAdapter: RecyclerWheelViewAdapter) {
        logDebug("setRecyclerWheelViewAdapter")
        adapter = recyclerWheelViewAdapter
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        //get first string item height, fix ui offset problem
        if (isMeasureFirst) {
            val childView = getChildAt(1)
            if (null != childView) {
                offsetY = childView.height / 2
                scrollBy(0, offsetY)
                isMeasureFirst = false
            }
        }
    }

    @Deprecated(
        "You should not setLayoutManager by yourself"
    )
    override fun setLayoutManager(layout: LayoutManager?) {
        logDebug("setLayoutManager")
        super.setLayoutManager(layout)
    }


}