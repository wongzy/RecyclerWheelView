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

    protected var pointY = 0

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
        if (adapter !is RecyclerWheelViewAdapter) {
            throw IllegalArgumentException("adapter is not a instance of RecyclerWheelViewAdapter")
        }
        super.setAdapter(adapter)
    }

    /**
     * set adapter
     */
    fun setRecyclerWheelViewAdapter(recyclerWheelViewAdapter: RecyclerWheelViewAdapter) {
        adapter = recyclerWheelViewAdapter
    }

    @Deprecated(
        "You should not setLayoutManager by yourself"
    )
    override fun setLayoutManager(layout: LayoutManager?) {
        super.setLayoutManager(layout)
    }


}