package com.turtle.nest.repository.dagger.module

import android.content.Context
import com.turtle.nest.repository.dagger.scope.AppScope
import com.turtle.nest.repository.networkoperator.NetworkAdapter
import dagger.Module
import dagger.Provides

@Module
class NetworkAdapterHelperModule(var context: Context) {
    @Provides
    @AppScope
    fun provideNetworkHelper(): NetworkAdapter {
        return NetworkAdapter.getInstance()
    }
}