package cn.wongzhenyu.recyclerwheelview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2020-02-03
 **/
abstract class AbstractRecyclerWheelViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private val typePadding = 0
    private val typeItem = 1

    private var itemList: MutableList<IRecyclerWheelViewItem>

    constructor(itemList: MutableList<IRecyclerWheelViewItem>) {
        this.itemList = itemList
        //need to put two empty element to list's head and end, it is aimed to create two padding item
        this.itemList.add(0, object : IRecyclerWheelViewItem {
            override fun getItemString(): String {
                return ""
            }
        })
        this.itemList.add(object : IRecyclerWheelViewItem {
            override fun getItemString(): String {
                return ""
            }
        })
    }

    /**
     * the index of start and end are padding item's index, not included in valid item
     */
    override fun getItemViewType(position: Int): Int {
        if (position == 0 || position == itemList.size) {
            return typePadding
        }
        return typeItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == typePadding) {
            TODO("return padding item")
        }
        return onCreateItemViewHolder(parent)
    }

    /**
     * create a Normal ViewHolder by your customized layout, you can change its property in onBindSelectedViewHolder and onBindNotSelectedViewHolder
     */
    abstract fun onCreateItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (isSelectedItem(position)) {
            onBindSelectedViewHolder(holder, position)
        } else {
            onBindNotSelectedViewHolder(holder, position)
        }
    }

    /**
     * bind selected item's ViewHolder
     */
    abstract fun onBindSelectedViewHolder(holder: RecyclerView.ViewHolder, position: Int)

    /**
     * bind not selected item's ViewHolder
     */
    abstract fun onBindNotSelectedViewHolder(holder: RecyclerView.ViewHolder, position: Int)


    private fun isSelectedItem(position: Int): Boolean {
        TODO("Judge if it is selected item")
    }

}