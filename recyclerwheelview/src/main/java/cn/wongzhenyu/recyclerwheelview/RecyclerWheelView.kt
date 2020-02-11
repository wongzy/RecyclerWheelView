package cn.wongzhenyu.recyclerwheelview

import android.content.Context
import android.util.AttributeSet
import android.view.ViewTreeObserver
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
    fun setRecyclerWheelViewAdapter(recyclerWheelViewAdapter: RecyclerWheelViewAdapter?) {
        setAdapter(recyclerWheelViewAdapter)
        initPreDrawListener()
    }

    /**
     * rewrite onPreDrawListener
     */
    private fun initPreDrawListener() {
        viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                viewTreeObserver.removeOnPreDrawListener(this)
                //todo build a bridge between adapter and view, get attributes
                return true
            }
        })
    }


}