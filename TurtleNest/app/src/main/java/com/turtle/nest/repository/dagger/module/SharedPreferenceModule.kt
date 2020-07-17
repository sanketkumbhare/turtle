package com.turtle.nest.repository.dagger.module

import android.content.Context
import com.turtle.nest.repository.dagger.SharedPreferenceHelper
import com.turtle.nest.repository.dagger.scope.AppScope
import com.turtle.nest.BuildConfig
import dagger.Module
import dagger.Provides

@Module
class SharedPreferenceModule(var context: Context) {

    @Provides @AppScope
    fun provideSharedPreference(): SharedPreferenceHelper {
        val preference = context.getSharedPreferences(BuildConfig.APP_PREF, Context.MODE_PRIVATE)
        return SharedPreferenceHelper(preference)
    }

}