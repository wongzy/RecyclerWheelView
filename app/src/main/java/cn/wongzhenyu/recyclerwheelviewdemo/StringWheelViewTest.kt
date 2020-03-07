package cn.wongzhenyu.recyclerwheelviewdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import cn.wongzhenyu.recyclerwheelview.StringRecyclerWheelView
import kotlinx.android.synthetic.main.activity_string.*

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2020-02-23
 **/
class StringWheelViewTest : AppCompatActivity() {

    private lateinit var stringList : MutableList<String>
    private lateinit var stringRecyclerWheelView: StringRecyclerWheelView
    private val tag = "StringWheelViewTest"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_string)
        stringRecyclerWheelView = string_wheel_view as StringRecyclerWheelView
        stringList = MutableList(20, init = {
            "value $it"
        })
        stringRecyclerWheelView.setStringItemList(stringList)
    }

    override fun onResume() {
        Log.d(tag, "onResume")
        super.onResume()
    }
}