package cn.wongzhenyu.recyclerwheelview

import android.content.res.Resources

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2019-12-21
 * Common utils in this project
 **/

fun dp2px(dp : Float) : Float {
    val density = Resources.getSystem().displayMetrics.density
    return dp * density
}

fun sp2px(sp : Float) : Float {
    val scaleDensity = Resources.getSystem().displayMetrics.scaledDensity
    return sp * scaleDensity
}