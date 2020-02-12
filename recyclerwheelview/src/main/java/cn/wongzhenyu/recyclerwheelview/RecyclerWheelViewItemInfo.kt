package cn.wongzhenyu.recyclerwheelview

import android.graphics.drawable.Drawable

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2020-02-12
 * attributes class
 **/
internal data class RecyclerWheelViewItemInfo(val wheelSelectedItemTextColor: Int, val wheelSelectedItemTextSize : Int,
                                     val wheelSelectedItemBackground : Drawable?, val wheelNormalTextSize : Int,
                                     val wheelNormalTextColor : Int, val wheelItemInterval : Int,
                                     val wheelNormalItemBackground: Drawable?)