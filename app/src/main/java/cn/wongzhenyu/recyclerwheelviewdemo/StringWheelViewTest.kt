package cn.wongzhenyu.recyclerwheelviewdemo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
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
    private lateinit var tvValue : TextView
    private val tag = "StringWheelViewTest"
    private var clickTime = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(tag, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_string)
        stringRecyclerWheelView = string_wheel_view as StringRecyclerWheelView
        tvValue = tv_string_vale
        stringList = MutableList(20, init = {
            "value $it"
        })
        stringRecyclerWheelView.setOnSelectedStringCallback(object : StringRecyclerWheelView.OnSelectedStringCallback{
            override fun onSelectedString(selectedString: String) {
                tvValue.text = "selected value : $selectedString"
            }
        })
        stringRecyclerWheelView.setStringItemList(stringList)
        update_string_button.setOnClickListener {
            stringList = MutableList(20, init = {
                "new value $it $clickTime"
            })
            clickTime ++
            stringRecyclerWheelView.setStringItemList(stringList)
        }
    }

    override fun onResume() {
        Log.d(tag, "onResume")
        super.onResume()
    }
}