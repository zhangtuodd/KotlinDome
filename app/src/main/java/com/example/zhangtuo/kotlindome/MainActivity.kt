package com.example.zhangtuo.kotlindome

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {

        message.text = "Hello Kotlin !"
        Log.i("tag", "text-----------" + message.text)

        jump_adapter.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // 荼毒必须去掉，kotlin中不会跳过荼毒，添加荼毒只能添加在执行最后
        when (v?.id) {
            R.id.jump_adapter ->
                startActivity(Intent(this@MainActivity, JumpActivity::class.java))
        }
    }
}


