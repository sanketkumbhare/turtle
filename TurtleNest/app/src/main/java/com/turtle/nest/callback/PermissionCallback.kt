package com.turtle.nest.callback

interface PermissionCallback {
    fun onPermissionGranted()
    fun onPermissionRejected()
}