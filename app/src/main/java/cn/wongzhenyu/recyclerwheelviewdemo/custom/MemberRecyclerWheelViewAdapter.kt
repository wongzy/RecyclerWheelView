package cn.wongzhenyu.recyclerwheelviewdemo.custom

import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.wongzhenyu.recyclerwheelview.RecyclerWheelViewAdapter
import cn.wongzhenyu.recyclerwheelviewdemo.R

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2020-03-19
 **/
class MemberRecyclerWheelViewAdapter : RecyclerWheelViewAdapter {

    private val memberList = ArrayList<Member>()

    constructor(memberList: MutableList<Member>) {
        this.memberList.addAll(memberList)
    }

    override fun onCreateItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_member_wheel_view, parent, false)
        return MemberViewHolder(view)
    }

    override fun onBindSelectedViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val memberViewHolder = holder as MemberViewHolder
        val member = memberList[position]
        memberViewHolder.nameView.text = member.name
        memberViewHolder.nameView.setTextColor(Color.BLACK)
        memberViewHolder.nameView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        memberViewHolder.ageView.text = member.age.toString()
        memberViewHolder.sexView.text = member.sex
    }

    override fun onBindNotSelectedViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val memberViewHolder = holder as MemberViewHolder
        val member = memberList[position]
        memberViewHolder.nameView.text = member.name
        memberViewHolder.nameView.setTextColor(Color.WHITE)
        memberViewHolder.nameView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        memberViewHolder.ageView.text = member.age.toString()
        memberViewHolder.sexView.text = member.sex
    }

    override fun getWheelItemCount(): Int {
        return memberList.size
    }

    class MemberViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameView : TextView = view.findViewById(R.id.member_name)
        val ageView : TextView = view.findViewById(R.id.member_age)
        val sexView : TextView = view.findViewById(R.id.member_sex)
    }
}