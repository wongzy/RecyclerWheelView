package cn.wongzhenyu.recyclerwheelview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.wongzhenyu.recyclerwheelview.util.logDebug
import cn.wongzhenyu.recyclerwheelview.util.logError
import cn.wongzhenyu.recyclerwheelview.util.logInfo

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2020-02-23
 **/

internal class StringRecyclerWheelViewAdapter : RecyclerWheelViewAdapter {

    private val stringList: MutableList<String>
    private val recyclerWheelViewItemInfo: RecyclerWheelViewItemInfo

    constructor(
        stringList: MutableList<String>,
        recyclerWheelViewItemInfo: RecyclerWheelViewItemInfo
    ) {
        this.stringList = stringList
        this.recyclerWheelViewItemInfo = recyclerWheelViewItemInfo
        itemHeight = recyclerWheelViewItemInfo.wheelItemHeight
    }

    override fun onBindSelectedViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        logInfo("onBindSelectedViewHolder position = $position")
        val itemViewHolderSelected = holder as ItemViewHolder
        itemViewHolderSelected.contentView.text = stringList[position]
        itemViewHolderSelected.contentView.setTextColor(recyclerWheelViewItemInfo.wheelSelectedItemTextColor)
        itemViewHolderSelected.contentView.textSize =
            recyclerWheelViewItemInfo.wheelSelectedItemTextSize.toFloat()
    }

    override fun onBindNotSelectedViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        logInfo("onBindNotSelectedViewHolder position = $position")
        val itemViewHolderUnSelected = holder as ItemViewHolder
        itemViewHolderUnSelected.contentView.text = stringList[position]
        itemViewHolderUnSelected.contentView.setTextColor(recyclerWheelViewItemInfo.wheelNormalTextColor)
        itemViewHolderUnSelected.contentView.textSize =
            recyclerWheelViewItemInfo.wheelNormalTextSize.toFloat()
    }

    override fun getWheelItemCount(): Int {
        logInfo("getWheelItemCount = ${stringList.size}")
        return stringList.size
    }

    override fun onCreateItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        logDebug("onCreateItemViewHolder")
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_nor_recycler_wheel_view, parent, false)
        val layoutParams = rootView.layoutParams;
        layoutParams.height = recyclerWheelViewItemInfo.wheelItemHeight
        rootView.layoutParams = layoutParams
        return ItemViewHolder(rootView)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val contentView: TextView = itemView.findViewById(R.id.tv_content)
    }

    override fun onSelectedItemPosition(position: Int) {
        if (position in stringList.indices) {
            StringRecyclerWheelView.onSelectedStringCallback?.onSelectedString(stringList[position])
        } else {
            logError("onSelectedItemPosition is wrong!")
        }
    }

}