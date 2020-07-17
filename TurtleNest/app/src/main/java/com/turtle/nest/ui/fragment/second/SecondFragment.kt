package com.turtle.nest.ui.fragment.second

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.turtle.nest.R
import com.turtle.nest.databinding.FragmentSecondBinding
import com.turtle.nest.utils.base.BaseFragment

class SecondFragment: BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_second
    override var viewModel: ViewModel
        get() = setUpVM(this,SecondFragmentVM())
        set(value) {}
    override var binding: ViewDataBinding
        get() = setUpBinding() as FragmentSecondBinding
        set(value) {}

    override fun bindData() {

    }

    override fun initListeners() {

    }

}