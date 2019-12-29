package cn.wongzhenyu.recyclerwheelview

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerWheelView : RecyclerView {

    var wheelSelectedItemTextColor  = -1





     constructor(context: Context, attributeSet : AttributeSet?) : super(context, attributeSet) {
         init(context, attributeSet)
     }

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr : Int) : super(context, attributeSet, defStyleAttr) {
        init(context, attributeSet)
    }

    private fun init(context: Context, attributeSet: AttributeSet?) {
        val attrs = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerWheelView)
//        wheelSelectedItemTextColor = attrs.getColor(R.styleable.RecyclerWheelView_wheelSelectedItemTextColor, )
        attrs.recycle()
    }
}