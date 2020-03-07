package cn.wongzhenyu.recyclerwheelview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.wongzhenyu.recyclerwheelview.util.logDebug
import cn.wongzhenyu.recyclerwheelview.util.logError
import cn.wongzhenyu.recyclerwheelview.util.logInfo

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2020-02-03
 **/

private const val typePadding = 0
private const val typeItem = 1

abstract class RecyclerWheelViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected var selectedItem = 1

    /**
     * the index of start and end are padding item's index, not included in valid item
     */
    final override fun getItemViewType(position: Int): Int {
        logInfo("getItemViewType position = $position")
        if (position == 0 || position == itemCount) {
            return typePadding
        }
        return typeItem
    }

    final override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        logInfo("onCreateViewHolder viewType = $viewType")
        if (viewType == typePadding) {
            return onCreatePaddingItemViewHolder(parent)
        }
        return onCreateItemViewHolder(parent)
    }


    private fun onCreatePaddingItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        logDebug("onCreatePaddingItemViewHolder")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_padding_recycler_wheel_view, parent, false)
        val height = parent.measuredHeight / 2
        val layoutParams = view.layoutParams
        layoutParams.height = height
        view.layoutParams = layoutParams
        return object : RecyclerView.ViewHolder(view) {
        }
    }

    /**
     * create a Normal ViewHolder by your customized layout, you can change its property in onBindSelectedViewHolder and onBindNotSelectedViewHolder
     */
    abstract fun onCreateItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    final override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        logInfo("onBindViewHolder position = $position")
        if (position == 0 || position == itemCount - 1) {
            logError("onBindViewHolder -- not need bind")
            return
        }
        if (isSelectedItem(position)) {
            onBindSelectedViewHolder(holder, position - 1)
        } else {
            onBindNotSelectedViewHolder(holder, position - 1)
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
        logDebug("getItemCount")
        return getWheelItemCount() + 2
    }


    private fun isSelectedItem(position: Int): Boolean {
        logInfo("isSelectedItem position = $position selectedItem = $selectedItem")
        return position == selectedItem
    }
}