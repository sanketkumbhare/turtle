package com.turtle.nest.ui.fragment.first

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.synnapps.carouselview.ImageListener
import com.turtle.nest.R
import com.turtle.nest.databinding.FragmentFirstBinding
import com.turtle.nest.utils.base.BaseFragment


class FirstFragment : BaseFragment() {

    val images = arrayListOf(
        R.drawable.i_am_legend,
        R.drawable.spirited,
        R.drawable.naruto,
        R.drawable.harry_potter,
        R.drawable.mad_max,
        R.drawable.lord_of_ring
    )
    private lateinit var mBinding: FragmentFirstBinding
    private lateinit var mFirstFragmentVM: FirstFragmentVM
    override val layoutId: Int
        get() = R.layout.fragment_first
    override var viewModel: ViewModel
        get() = setUpVM(this, FirstFragmentVM())
        set(value) {}
    override var binding: ViewDataBinding
        get() = setUpBinding() as FragmentFirstBinding
        set(value) {}


    override fun bindData() {
        attachObserver()
    }

    override fun initListeners() {

    }

  private  fun attachObserver(){
        mBinding.firstFragmentModel?.apiresponse?.observe(this, Observer {
            val msg = it.data?.rstr
            Toast.makeText(activity,msg,Toast.LENGTH_SHORT).show()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding = binding as FragmentFirstBinding
        mBinding.firstFragmentModel = FirstFragmentVM()

        //Caurosel View
        try {
            mBinding.carouselView.setImageListener(imageListener)
            mBinding.carouselView.pageCount = images.size;
        }catch (e:Exception){
            e.stackTrace
        }


        //Button Click Api
        mBinding.buttonProgressRight.setOnClickListener {
            mBinding.firstFragmentModel?.buttonClicked(mBinding.buttonProgressRight.text.toString())
        }
        mBinding.buttonProgressLeft.setOnClickListener {
            mBinding.firstFragmentModel?.buttonClicked(mBinding.buttonProgressLeft.text.toString())
        }
        mBinding.buttonProgressRight1.setOnClickListener {
            mBinding.firstFragmentModel?.buttonClicked(mBinding.buttonProgressRight1.text.toString())
        }
        mBinding.buttonProgressLeft1.setOnClickListener {
            mBinding.firstFragmentModel?.buttonClicked(mBinding.buttonProgressLeft1.text.toString())
        }
        // Hide progress and show "Submit" text instead
    }

     var imageListener =
        ImageListener { position, imageView -> imageView.setImageResource(images[position]) }





}


