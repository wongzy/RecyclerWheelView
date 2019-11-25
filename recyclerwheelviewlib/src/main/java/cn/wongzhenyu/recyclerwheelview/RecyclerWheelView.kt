package cn.wongzhenyu.recyclerwheelview

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerWheelView : RecyclerView {

     constructor(context: Context, attributeSet : AttributeSet?) : super(context, attributeSet) {

     }

    constructor(context: Context) : super(context) {

    }

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr : Int) : super(context, attributeSet, defStyleAttr) {

    }

    abstract class Adapter<VH : ViewHolder>: RecyclerView.Adapter<ViewHolder> {
        constructor() {
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getItemCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}