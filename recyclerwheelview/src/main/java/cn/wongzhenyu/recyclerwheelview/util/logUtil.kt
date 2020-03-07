package cn.wongzhenyu.recyclerwheelview.util

import android.util.Log
import cn.wongzhenyu.recyclerwheelview.BuildConfig

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2020-03-07
 * utils about log
 **/


private const val TAG = "RecyclerWheelView"


internal fun logDebug(message: String) {
    if (BuildConfig.DEBUG) {
        Log.d(TAG, message)
    }
}

internal fun logInfo(message: String) {
    if (BuildConfig.DEBUG) {
        Log.i(TAG, message)
    }
}

internal fun logWarn(message: String) {
    if (BuildConfig.DEBUG) {
        Log.w(TAG, message)
    }
}

internal fun logError(message: String) {
    if (BuildConfig.DEBUG) {
        Log.e(TAG, message)
    }
}