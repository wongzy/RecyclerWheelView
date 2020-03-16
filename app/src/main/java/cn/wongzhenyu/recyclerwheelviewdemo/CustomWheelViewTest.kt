package cn.wongzhenyu.recyclerwheelviewdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2020-03-16
 **/

class CustomWheelViewTest : AppCompatActivity() {

    private val tag = "CustomWheelViewTest"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate")
        setContentView(R.layout.activity_custom)
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }
}