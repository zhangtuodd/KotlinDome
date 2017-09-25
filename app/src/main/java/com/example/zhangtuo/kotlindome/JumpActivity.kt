package com.example.zhangtuo.kotlindome

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_jump.*

class JumpActivity : AppCompatActivity() {

    //lateinit的使用还是有很多限制的，比如只能在不可null的对象上使用，比须为var,逼迫你一定要初始化这个变量
    private lateinit var myAdapter: MyAdapter
    //MutableList 创建可改变的list集合
    var list: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jump)
        init()
    }

    private fun init() {
        //Kotlin相对于Java新加入的特性，取代for(int i=0;i<5;i++)用于简单的重复工作
        repeat(30) { i ->
            list.add(i, "first step")
        }
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@JumpActivity)
            myAdapter = MyAdapter(this@JumpActivity)
            recycler_view.adapter = myAdapter
        }

        myAdapter.bindData(list)
    }
}

