package com.turtle.nest.repository.dagger.component

import com.turtle.nest.repository.dagger.module.NetworkAdapterHelperModule
import com.turtle.nest.repository.dagger.scope.FragmentScope
import dagger.Component

@FragmentScope
@Component(modules = [NetworkAdapterHelperModule::class])
interface FragmentComponent {

//    fun inject(app: LoginFragment)

}