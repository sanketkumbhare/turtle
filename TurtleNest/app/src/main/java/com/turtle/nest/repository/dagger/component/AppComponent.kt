package com.turtle.nest.repository.dagger.component

import com.turtle.nest.repository.dagger.module.AppHelperModule
import com.turtle.nest.repository.dagger.module.NetworkAdapterHelperModule
import com.turtle.nest.repository.dagger.module.SharedPreferenceModule
import com.turtle.nest.repository.dagger.scope.AppScope
import com.turtle.nest.utils.base.BaseActivity
import dagger.Component

@AppScope
@Component(modules = [AppHelperModule::class, SharedPreferenceModule::class, NetworkAdapterHelperModule::class])
interface AppComponent {
    fun inject(app: BaseActivity)
}
