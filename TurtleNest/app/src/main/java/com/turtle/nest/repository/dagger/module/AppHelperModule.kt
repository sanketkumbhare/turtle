package com.turtle.nest.repository.dagger.module

import com.turtle.nest.repository.dagger.AppHelper
import com.turtle.nest.repository.dagger.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class AppHelperModule {

    @Provides @AppScope
    fun provideAppHelper(): AppHelper {
        return AppHelper()
    }

}