package com.turtle.nest.ui.home

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.turtle.nest.R
import com.turtle.nest.databinding.ActivityHomeBaseBinding
import com.turtle.nest.ui.fragment.first.FirstFragment
import com.turtle.nest.ui.fragment.second.SecondFragment
import com.turtle.nest.utils.base.BaseActivity
import com.turtle.nest.utils.base.BaseVM
import com.turtle.nest.utils.openFragment
import me.ibrahimsn.lib.OnItemSelectedListener

class HomeBaseActivity : BaseActivity() {

    private lateinit var mBaseBinding: ActivityHomeBaseBinding
    private lateinit var mHomeBaseVM: HomeBaseViewModel
    override val mViewDataBinding: ViewDataBinding
        get() = setUpBinding() as ActivityHomeBaseBinding
    override val layoutId: Int
        get() = R.layout.activity_home_base
    override var viewModel: ViewModel
        get() = setUpVM(this, HomeBaseViewModel())
        set(value) {}
    override val context: Context
        get() = this


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBaseBinding = binding as ActivityHomeBaseBinding
        mBaseBinding.homeBaseModel = HomeBaseViewModel()
        openFragment(mBaseBinding.mainFragment.id, FirstFragment())

        mBaseBinding.bottomBar.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelect(pos: Int): Boolean {
                when (pos) {
                   0 -> {
                        openFragment(mBaseBinding.mainFragment.id, FirstFragment())
                    }
                   1 -> {
                        openFragment(mBaseBinding.mainFragment.id, SecondFragment())
                    }
                    2 -> {
                        openFragment(mBaseBinding.mainFragment.id, SecondFragment())
                    }
                }
                return true
            }

        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun bindData() {
        // mHomeBaseVM = mBaseBinding.homeBaseModel
    }

    override fun initListeners() {

    }
}
