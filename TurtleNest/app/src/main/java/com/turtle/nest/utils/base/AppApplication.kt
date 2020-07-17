package com.turtle.nest.utils.base

import android.app.Application
import com.turtle.nest.repository.dagger.component.AppComponent
import com.turtle.nest.repository.dagger.module.AppHelperModule
import com.turtle.nest.repository.dagger.module.NetworkAdapterHelperModule
import com.turtle.nest.repository.dagger.module.SharedPreferenceModule
import com.turtle.nest.repository.networkcheck.NetworkSchedulerService
import android.content.Intent
import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.turtle.nest.repository.networkcheck.ConnectivityReceiver
import android.app.job.JobScheduler
import android.app.job.JobInfo
import android.content.ComponentName
import android.content.Context
import com.turtle.nest.repository.dagger.component.DaggerAppComponent


class AppApplication : Application(), LifecycleObserver, ConnectivityReceiver.ConnectivityReceiverListener {
    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        Log.e("AppApplication", "isConnected : $isConnected")
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        val component = initDaggerComponent()
        this.appComponent = component
      //  startConnectivityService()
        scheduleJob()
    }

    private fun startConnectivityService() {
        val startServiceIntent = Intent(applicationContext, NetworkSchedulerService::class.java)
        startService(startServiceIntent)
    }

    private fun stopConnectivityService() {
        stopService(Intent(applicationContext, NetworkSchedulerService::class.java))
    }


    private fun initDaggerComponent(): AppComponent {
        return DaggerAppComponent.builder()
            .appHelperModule(AppHelperModule())
            .sharedPreferenceModule(SharedPreferenceModule(applicationContext))
            .networkAdapterHelperModule(NetworkAdapterHelperModule(applicationContext))
            .build()
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onEnterForeground() {
        Log.d("AppController", "Foreground")
        startConnectivityService()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onEnterBackground() {
        Log.d("AppController", "Background")
        stopConnectivityService()
    }

    private fun scheduleJob() {
        val myJob = JobInfo.Builder(0, ComponentName(this, NetworkSchedulerService::class.java))
            .setRequiresCharging(true)
            .setMinimumLatency(1000)
            .setOverrideDeadline(2000)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            .setPersisted(true)
            .build()

        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.schedule(myJob)
    }

}