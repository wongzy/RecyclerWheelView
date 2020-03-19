package cn.wongzhenyu.recyclerwheelviewdemo.custom

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.wongzhenyu.recyclerwheelview.RecyclerWheelViewAdapter

/**
 * github wongzy
 * wongzhenyu96@gmail.com
 * 2020-03-19
 **/
class MemberRecyclerWheelViewAdapter : RecyclerWheelViewAdapter{

    private val memberList = ArrayList<Member>()

    constructor(memberList: MutableList<Member>) {
        this.memberList.addAll(memberList)
    }

    override fun onCreateItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindSelectedViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindNotSelectedViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getWheelItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}