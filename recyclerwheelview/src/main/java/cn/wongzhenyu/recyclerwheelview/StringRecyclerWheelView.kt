package cn.wongzhenyu.recyclerwheelview

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.ViewTreeObserver
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import cn.wongzhenyu.recyclerwheelview.util.*
import cn.wongzhenyu.recyclerwheelview.util.dp2px
import cn.wongzhenyu.recyclerwheelview.util.logDebug
import cn.wongzhenyu.recyclerwheelview.util.logInfo
import cn.wongzhenyu.recyclerwheelview.util.logWarn
import cn.wongzhenyu.recyclerwheelview.util.sp2px
import javax.security.auth.login.LoginException

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2019-12-29
 **/
class StringRecyclerWheelView : RecyclerWheelView {

    private lateinit var recyclerWheelViewItemInfo: RecyclerWheelViewItemInfo
    private val stringItemList: MutableList<String> = ArrayList()


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
        val wheelItemInterval = attrs.getDimensionPixelSize(
            R.styleable.StringRecyclerWheelView_wheelNormalTextSize,
            dp2px(15f).toInt()
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
            wheelItemInterval,
            wheelNormalItemBackground
        )
        attrs.recycle()
        logInfo("init recyclerWheelViewItemInfo = $recyclerWheelViewItemInfo")
    }


    fun setStringItemList(stringList: MutableList<String>) {
        logInfo("setStringItemList size = ${stringList.size}")
        this.stringItemList.addAll(stringList)
        initPreDrawListener()
    }

    /**
     * rewrite onPreDrawListener
     */
    private fun initPreDrawListener() {
        logInfo("initPreDrawListener")
        layoutManager = LinearLayoutManager(context, VERTICAL, false)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(this@StringRecyclerWheelView)
        val singleRecyclerWheelViewAdapter =
            StringRecyclerWheelViewAdapter(stringItemList, recyclerWheelViewItemInfo)
        setRecyclerWheelViewAdapter(singleRecyclerWheelViewAdapter)
        viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                logWarn("preDrawListener onPreDraw")
                viewTreeObserver.removeOnPreDrawListener(this)
                addOnScrollListener(object : OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        logDebug("scrollListener onScrolled")
                        super.onScrolled(recyclerView, dx, dy)
                        pointY += dy
                        singleRecyclerWheelViewAdapter.notifyScroll(pointY)
                    }
                })
                return true
            }
        })
    }

}