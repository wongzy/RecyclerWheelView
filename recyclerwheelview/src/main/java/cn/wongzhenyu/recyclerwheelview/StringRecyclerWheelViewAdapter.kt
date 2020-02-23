package cn.wongzhenyu.recyclerwheelview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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
    }

    override fun onBindSelectedViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolderSelected = holder as ItemViewHolder
        itemViewHolderSelected.contentView.text = stringList[position]
        itemViewHolderSelected.contentView.setTextColor(recyclerWheelViewItemInfo.wheelSelectedItemTextColor)
        itemViewHolderSelected.contentView.textSize =
            recyclerWheelViewItemInfo.wheelSelectedItemTextSize.toFloat()
        val layoutParams = itemViewHolderSelected.itemView.layoutParams
        layoutParams.height =
            itemViewHolderSelected.contentView.height + recyclerWheelViewItemInfo.wheelItemInterval
        itemViewHolderSelected.itemView.layoutParams = layoutParams
    }

    override fun onBindNotSelectedViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolderUnSelected = holder as ItemViewHolder
        itemViewHolderUnSelected.contentView.text = stringList[position]
        itemViewHolderUnSelected.contentView.setTextColor(recyclerWheelViewItemInfo.wheelNormalTextColor)
        itemViewHolderUnSelected.contentView.textSize =
            recyclerWheelViewItemInfo.wheelSelectedItemTextSize.toFloat()
        val layoutParams = itemViewHolderUnSelected.itemView.layoutParams
        layoutParams.height =
            itemViewHolderUnSelected.contentView.height + recyclerWheelViewItemInfo.wheelItemInterval
        itemViewHolderUnSelected.itemView.layoutParams = layoutParams
    }

    override fun getWheelItemCount(): Int {
        return stringList.size
    }

    override fun onCreateItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_nor_recycler_wheel_view, parent, false)
        return ItemViewHolder(rootView)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val contentView: TextView = itemView.findViewById(R.id.tv_content)
    }

    /**
     * calculate selected item and notify
     */
    fun notifyScroll(scrolledY: Int) {
        val newSelectedItem =
            scrolledY / (recyclerWheelViewItemInfo.wheelNormalTextSize + recyclerWheelViewItemInfo.wheelItemInterval) + 1
        val oldSelectedItem = selectedItem
        if (newSelectedItem != oldSelectedItem) {
            selectedItem = newSelectedItem
            notifyItemChanged(oldSelectedItem)
            notifyItemChanged(selectedItem)
        }
    }
}