package cn.wongzhenyu.recyclerwheelview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2020-02-03
 **/

private const val typePadding = 0
private const val typeItem = 1

abstract class RecyclerWheelViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    /**
     * the index of start and end are padding item's index, not included in valid item
     */
    final override fun getItemViewType(position: Int): Int {
        if (position == 0 || position == itemCount) {
            return typePadding
        }
        return typeItem
    }

    final override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        if (viewType == typePadding) {
            return onCreatePaddingItemViewHolder(parent)
        }
        return onCreateItemViewHolder(parent)
    }


    private fun onCreatePaddingItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_padding_recycler_wheel_view, parent, false)
        return object : RecyclerView.ViewHolder(view) {
        }
    }

    /**
     * create a Normal ViewHolder by your customized layout, you can change its property in onBindSelectedViewHolder and onBindNotSelectedViewHolder
     */
    abstract fun onCreateItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    final override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0 || position == itemCount - 1) {
            return
        }
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

    /**
     * get item size
     */
    abstract fun getWheelItemCount(): Int

    final override fun getItemCount(): Int {
        return getWheelItemCount() + 2
    }


    private fun isSelectedItem(position: Int): Boolean {
        TODO("Judge is it a selected item")
    }
}