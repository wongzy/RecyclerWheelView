package cn.wongzhenyu.recyclerwheelview

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import cn.wongzhenyu.recyclerwheelview.util.dp2px
import cn.wongzhenyu.recyclerwheelview.util.logError
import cn.wongzhenyu.recyclerwheelview.util.logInfo
import cn.wongzhenyu.recyclerwheelview.util.sp2px

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2019-12-29
 **/
class StringRecyclerWheelView : RecyclerWheelView {

    private lateinit var recyclerWheelViewItemInfo: RecyclerWheelViewItemInfo
    private val stringItemList: MutableList<String> = ArrayList()

    companion object {
        internal var onSelectedStringCallback: OnSelectedStringCallback? = null
    }

    fun setOnSelectedStringCallback(onSelectedStringCallback: OnSelectedStringCallback?) {
        StringRecyclerWheelView.onSelectedStringCallback = onSelectedStringCallback
    }


    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        init(context, attributeSet)
    }

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    ) {
        init(context, attributeSet)
    }

    private fun init(context: Context, attributeSet: AttributeSet?) {
        val attrs =
            context.obtainStyledAttributes(attributeSet, R.styleable.StringRecyclerWheelView)
        val wheelSelectedItemTextColor = attrs.getColor(
            R.styleable.StringRecyclerWheelView_wheelSelectedItemTextColor,
            resources.getColor(R.color.default_wheelSelectedItemTextColor)
        )
        val wheelSelectedItemTextSize = attrs.getDimensionPixelSize(
            R.styleable.StringRecyclerWheelView_wheelSelectedTextSize,
            sp2px(15.5f).toInt()
        )
        val wheelSelectedItemBackground = attrs.getDrawable(
            R.styleable.StringRecyclerWheelView_wheelSelectedItemBackground
        )
        val wheelNormalTextSize = attrs.getDimensionPixelSize(
            R.styleable.StringRecyclerWheelView_wheelNormalTextSize,
            sp2px(13.5f).toInt()
        )
        val wheelNormalTextColor = attrs.getColor(
            R.styleable.StringRecyclerWheelView_wheelNormalTextColor,
            resources.getColor(R.color.default_wheelNormalTextColor)
        )
        val wheelItemHeight = attrs.getDimensionPixelSize(
            R.styleable.StringRecyclerWheelView_wheelItemHeight,
            dp2px(65f).toInt()
        )
        val wheelNormalItemBackground = attrs.getDrawable(
            R.styleable.StringRecyclerWheelView_wheelNormalItemBackground
        )
        recyclerWheelViewItemInfo = RecyclerWheelViewItemInfo(
            wheelSelectedItemTextColor,
            wheelSelectedItemTextSize,
            wheelSelectedItemBackground,
            wheelNormalTextSize,
            wheelNormalTextColor,
            wheelItemHeight,
            wheelNormalItemBackground
        )
        attrs.recycle()
        logInfo("init recyclerWheelViewItemInfo = $recyclerWheelViewItemInfo")
    }


    /**
     * set strings list
     */
    fun setStringItemList(stringList: MutableList<String>) {
        //todo update strings when string list existed
        logInfo("setStringItemList size = ${stringList.size}")
        if (stringList.isEmpty()) {
            logError("string list is empty, please add elements to it!")
            return
        }
        this.stringItemList.clear()
        this.stringItemList.addAll(stringList)
        if (null == adapter) {
            initAdapterAndScroller()
        } else {
            updateDataAndNotify()
        }
    }

    @Deprecated(
        "do not set adapter in StringRecyclerWheelView, just use setStringItemList instead"
    )
    override fun setRecyclerWheelViewAdapter(recyclerWheelViewAdapter: RecyclerWheelViewAdapter) {
        super.setRecyclerWheelViewAdapter(recyclerWheelViewAdapter)
    }

    /**
     * init attributes and set adapter
     */
    private fun initAdapterAndScroller() {
        logInfo("initAdapterAndScroller")
        val stringRecyclerWheelViewAdapter =
            StringRecyclerWheelViewAdapter(stringItemList, recyclerWheelViewItemInfo)
        layoutManager = LinearLayoutManager(context, VERTICAL, false)
        setRecyclerWheelViewAdapter(stringRecyclerWheelViewAdapter)
        //invoke onSelectedItemCallback first before add ScrollListener
        scrollToPosition(0)
        pointY = 0
        stringRecyclerWheelViewAdapter.notifyScroll(0)
        addScrollListener()
    }

    /**
     * selected string callback
     */
    interface OnSelectedStringCallback {
        /**
         * get selected string
         */
        fun onSelectedString(selectedString: String)
    }
}