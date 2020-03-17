package cn.wongzhenyu.recyclerwheelview

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import cn.wongzhenyu.recyclerwheelview.util.dp2px
import cn.wongzhenyu.recyclerwheelview.util.logDebug
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
    private var onSelectedStringCallback : OnSelectedStringCallback? = null
    private var isMeasureFirst = true
    private var offsetY : Int = 0


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
        //remove change item animator
        itemAnimator = null
        logInfo("init recyclerWheelViewItemInfo = $recyclerWheelViewItemInfo")
    }

    /**
     * set OnSelectedStringCallback to get selected String
     */
    fun setOnSelectedStringCallback(onSelectedStringCallback: OnSelectedStringCallback) {
        this.onSelectedStringCallback = onSelectedStringCallback
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
            initAdapterAndScrollener()
        } else {
            updateStringsAndNotify()
        }
    }

    /**
     * update strings and scrolled length
     */
    private fun updateStringsAndNotify() {
        logDebug("updateStringsAndNotify")
        scrollToPosition(0)
        isMeasureFirst = true
        pointY = 0
        val stringRecyclerWheelViewAdapter = adapter as StringRecyclerWheelViewAdapter
        stringRecyclerWheelViewAdapter.resetScroll(onSelectedStringCallback)
    }

    /**
     * init attributes and set adapter
     */
    private fun initAdapterAndScrollener() {
        logInfo("initAdapterAndScrollener")
        val stringRecyclerWheelViewAdapter =
            StringRecyclerWheelViewAdapter(stringItemList, recyclerWheelViewItemInfo)
        layoutManager = LinearLayoutManager(context, VERTICAL, false)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(this@StringRecyclerWheelView)
        setRecyclerWheelViewAdapter(stringRecyclerWheelViewAdapter)
        //invoke onSelectedStringCallback first before add ScrollListener
        scrollToPosition(0)
        pointY = 0
        stringRecyclerWheelViewAdapter.notifyScroll(0, onSelectedStringCallback)
        addOnScrollListener(object : OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                logDebug("scrollListener onScrolled")
                super.onScrolled(recyclerView, dx, dy)
                pointY += dy
                stringRecyclerWheelViewAdapter.notifyScroll(pointY, onSelectedStringCallback)
            }
        })
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
        if (isMeasureFirst) {
            val childView = getChildAt(1)
            if (null != childView) {
                offsetY = childView.height / 2
                scrollBy(0, offsetY)
                isMeasureFirst = false
            }
        }
    }

    /**
     * selected string callback
     */
    interface OnSelectedStringCallback {
        /**
         * get selected string
         */
        fun onSelectedString(selectedString : String)
    }
}