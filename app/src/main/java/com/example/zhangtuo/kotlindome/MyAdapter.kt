package com.example.zhangtuo.kotlindome

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast


/**
 * Created by zhangtuo on 2017/9/25.
 */
class MyAdapter(private var context: Context) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

private lateinit var arrayList :List<String>

    fun bindData(arrayList: List<String>){
        this.arrayList = arrayList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.item_tv?.text = arrayList.get(position) + position
        holder?.itemView?.setOnClickListener{
            Toast.makeText(context,"click - "+position,Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        if (arrayList == null) {
            return 0
        }
        return arrayList.size
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * 基本语法介绍
     * val 代表这个 东西是个常量 只读 ，不能重新赋值
     * var 代表这个是个 变量，可以被重新赋值
     * 可变的默认字体高亮有下划线
     *
     * val a : "***" ----冒号后面代表这个是什么东西（int String View....）
     */
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {


        val inflate: LinearLayout = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false) as LinearLayout

        //kotlin 不用new这个关键字
        return MyViewHolder(inflate)
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var item_tv: TextView = itemView?.findViewById(R.id.item_tv) as TextView
    }
}