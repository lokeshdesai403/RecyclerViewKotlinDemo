package com.android4dev.recyclerview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android4dev.recyclerview.R.id.*
import com.android4dev.recyclerview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
    }

    private fun initView() {
        buttonSimpleRecyclerView.setOnClickListener(this)
        buttonGridRecyclerView.setOnClickListener(this)
        buttonViewTypeRecyclerView.setOnClickListener(this)
        buttonStaggeredRecyclerView.setOnClickListener(this)
        buttonLoadMoreRecyclerView.setOnClickListener(this)
    }

    override fun onClick(clickView: View?) {
        val intent: Intent
        when (clickView!!.id) {
            R.id.buttonSimpleRecyclerView -> {
                intent = Intent(this@HomeActivity, RecyclerViewLinearLayoutActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonGridRecyclerView -> {
                intent = Intent(this@HomeActivity, RecyclerViewGridLayoutActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonViewTypeRecyclerView -> {
                intent = Intent(this@HomeActivity, RecyclerViewHeaderFooterActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonStaggeredRecyclerView -> {
                intent = Intent(this@HomeActivity, RecyclerViewStaggeredGridActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonLoadMoreRecyclerView -> {
                intent = Intent(this@HomeActivity, RecyclerViewLoadMoreDataActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
