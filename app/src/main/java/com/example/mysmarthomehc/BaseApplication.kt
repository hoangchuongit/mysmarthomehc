/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2021 Tuya Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.example.mysmarthomehc

import android.app.Application
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import com.thingclips.smart.home.sdk.ThingHomeSdk
import com.thingclips.smart.optimus.sdk.ThingOptimusSdk

class BaseApplication : Application() {

    private var isInitialized = false

    override fun onCreate() {
        super.onCreate()
        val appContext = applicationContext
        val applicationInfo = appContext.packageManager.getApplicationInfo(appContext.packageName, PackageManager.GET_META_DATA)
        val bundle = applicationInfo.metaData
        val appKey = bundle.getString("THING_SMART_APPKEY");
        val appSecret = bundle.getString("THING_SMART_SECRET");

        Log.d("BaseApplication", "Initializing ThingHomeSdk with appKey: $appKey, appSecret: $appSecret")

        try {
            ThingHomeSdk.init(this, "3d3m9upqec9xpc8d3ve7", "q9gtdcepy8uvprxhsu8e53ed9tr8xgs2")
            ThingHomeSdk.setDebugMode(true)
            ThingOptimusSdk.init(this)
            isInitialized = true
            Log.d("BaseApplication", "ThingHomeSdk is initialized")
        } catch (e: Exception) {
            Log.e("BaseApplication", "Failed to initialize ThingHomeSdk", e)
        }


    }
}