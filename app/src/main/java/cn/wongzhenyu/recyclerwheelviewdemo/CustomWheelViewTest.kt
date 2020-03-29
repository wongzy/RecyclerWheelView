package cn.wongzhenyu.recyclerwheelviewdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import cn.wongzhenyu.recyclerwheelviewdemo.custom.Member
import cn.wongzhenyu.recyclerwheelviewdemo.custom.MemberRecyclerWheelViewAdapter
import kotlinx.android.synthetic.main.activity_custom.*
import java.util.*

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
        memberAdapter.setOnSelectedMemberCallBack(object : MemberRecyclerWheelViewAdapter.OnSelectedMemberCallBack{
            override fun onSelectedMamber(member: Member) {
                tv_string_vale.text = "${member.name} age = ${member.age}"
            }
        })
        recycler_wheel_view.setRecyclerWheelViewAdapter(memberAdapter)
        update_data_button.setOnClickListener {
            val newMemberList = MutableList(20, init = {
                Member(it + 1, "new member ${Random().nextInt(100)}  $it", 0, "new unKnow", "new none")
            })
            memberAdapter.updateData(newMemberList)
            recycler_wheel_view.updateDataAndNotify()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }
}