package cn.wongzhenyu.recyclerwheelview

import android.content.Context
import android.util.AttributeSet
import android.view.ViewTreeObserver
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2020-02-05
 **/

abstract class RecyclerWheelView : RecyclerView {

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
        initPreDrawListener(recyclerWheelViewAdapter)
    }

    @Deprecated(
        "You should not setLayoutManager by yourself"
    )
    override fun setLayoutManager(layout: LayoutManager?) {
        super.setLayoutManager(layout)
    }

    /**
     * rewrite onPreDrawListener
     */
    private fun initPreDrawListener(recyclerWheelViewAdapter: RecyclerWheelViewAdapter) {
        viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                viewTreeObserver.removeOnPreDrawListener(this)
                //todo build a bridge between adapter and view, get attributes
                setAdapter(recyclerWheelViewAdapter)
                layoutManager = LinearLayoutManager(context)
                return true
            }
        })
    }


}