package cn.wongzhenyu.recyclerwheelviewdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import cn.wongzhenyu.recyclerwheelviewdemo.custom.Member
import cn.wongzhenyu.recyclerwheelviewdemo.custom.MemberRecyclerWheelViewAdapter
import kotlinx.android.synthetic.main.activity_custom.*

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
        val memberList = MutableList(25, init = {
            Member(it, "member $it", 0, "unKnow", "none")
        })
        val memberAdapter = MemberRecyclerWheelViewAdapter(memberList)
        recycler_wheel_view.setRecyclerWheelViewAdapter(memberAdapter)
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }
}