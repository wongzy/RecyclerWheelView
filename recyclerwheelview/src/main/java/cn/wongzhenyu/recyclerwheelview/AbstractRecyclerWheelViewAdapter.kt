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

    override fun getItemViewType(position: Int): Int {
        if (position == 0 || position == itemList.size) {
            return typePadding
        }
        return typeItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}